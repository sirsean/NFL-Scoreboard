package com.vikinghammer.nfl.scoreboard.free;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vikinghammer.nfl.scoreboard.adapter.WeekScheduleAdapter;
import com.vikinghammer.nfl.scoreboard.model.AllWeeks;
import com.vikinghammer.nfl.scoreboard.model.WeekInfo;
import com.vikinghammer.nfl.scoreboard.model.WeekSchedule;
import com.vikinghammer.nfl.scoreboard.task.AllWeeksDownloadTask;
import com.vikinghammer.nfl.scoreboard.task.AsyncTaskListener;
import com.vikinghammer.nfl.scoreboard.task.WeekScheduleDownloadTask;
import com.vikinghammer.nfl.scoreboard.util.NFLUtil;

public class NFLScoreboardActivity extends Activity {
	
	private Context mContext = this;
	
	private ListView mWeekScheduleList;
	private WeekScheduleAdapter mWeekScheduleAdapter;
	
	private Button mPreviousWeekButton;
	private Button mNextWeekButton;
	private TextView mCurrentWeekView;
	
	private Button mThisWeekButton;
	private Button mRefreshButton;
	
	private View mStatusView;
	private View mStatusLoadingView;
	private View mStatusEmptyView;
	private View mStatusErrorView;
	
	private AllWeeksDownloadTask mAllWeeksDownloadTask;
	private WeekScheduleDownloadTask mWeekScheduleDownloadTask;
	
	private WeekInfo mLastKnownWeek;
	private WeekInfo mCurrentWeek;
	private WeekSchedule mCurrentSchedule;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        mStatusView = findViewById(R.id.main_status);
        mStatusLoadingView = findViewById(R.id.main_status_loading);
        mStatusEmptyView = findViewById(R.id.main_status_empty);
        mStatusErrorView = findViewById(R.id.main_status_error);
        
        mPreviousWeekButton = (Button)findViewById(R.id.previous_week_button);
        mNextWeekButton = (Button)findViewById(R.id.next_week_button);
        mCurrentWeekView = (TextView)findViewById(R.id.main_current_week);
        
        mThisWeekButton = (Button)findViewById(R.id.this_week_button);
        mRefreshButton = (Button)findViewById(R.id.refresh_button);
        
        mWeekScheduleList = (ListView)findViewById(R.id.main_list);
        
        mPreviousWeekButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if (mCurrentSchedule != null) {
					Log.i("Previous Clicked", String.format("Current: %s, Last Known: %s", mCurrentWeek.getWeekName(), mLastKnownWeek.getWeekName()));
					if ((mLastKnownWeek == null) || mLastKnownWeek.equals(mCurrentWeek)) {
						mCurrentWeek = mCurrentSchedule.getWeek().getPrevious();
					} else {
						mCurrentWeek = mLastKnownWeek;
					}
					show(Show.LOADING);
					mWeekScheduleList.setAdapter(null);
					downloadWeekSchedule();
					updateDisplay();
				}
			}
		});
        mNextWeekButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mCurrentSchedule != null) {
					Log.i("Next Clicked", String.format("Current: %s, Last Known: %s", mCurrentWeek.getWeekName(), mLastKnownWeek.getWeekName()));
					if ((mLastKnownWeek == null) || mLastKnownWeek.equals(mCurrentWeek)) {
						mCurrentWeek = mCurrentSchedule.getWeek().getNext();
					} else {
						mCurrentWeek = mLastKnownWeek;
					}
					show(Show.LOADING);
					mWeekScheduleList.setAdapter(null);
					downloadWeekSchedule();
					updateDisplay();
				}
			}
		});
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				show(Show.LOADING);
				downloadWeekSchedule();
			}
		});
        mThisWeekButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mWeekScheduleList.setAdapter(null);
				downloadAllWeeks();
			}
		});
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	
    	downloadAllWeeks();
    }
    
    private void updateDisplay() {
    	if (mCurrentWeek != null) {
    		mCurrentWeekView.setText(mCurrentWeek.getWeekName());
    	} else {
    		mCurrentWeekView.setText("...");
    	}
    }
    
    private void downloadAllWeeks() {
    	show(Show.LOADING);
    	mAllWeeksDownloadTask = new AllWeeksDownloadTask(new AsyncTaskListener() {
    		public void onComplete(Object item) {
    			Log.i("AllWeeksDownloadComplete", "Got all weeks");
    			AllWeeks allWeeks = (AllWeeks)item;
    			if (allWeeks != null) {
    				Log.i("Current Week", String.format("%s", allWeeks.getCurrent().getWeek()));
    				mCurrentWeek = allWeeks.getCurrent();
    				updateDisplay();
    				downloadWeekSchedule();
    			} else {
    				Log.i("AllWeeks failed", "Didn't get all weeks");
    				show(Show.ERROR);
    			}
    		}
    		
    		public Context getContext() {
    			return mContext;
    		}
    	});
    	mAllWeeksDownloadTask.execute(NFLUtil.allWeeksUrl());
    }
    
    private void downloadWeekSchedule() {
    	if (mCurrentWeek == null) {
    		downloadAllWeeks();
    	} else {
	    	mWeekScheduleDownloadTask = new WeekScheduleDownloadTask(new AsyncTaskListener() {
	    		public void onComplete(Object item) {
	    			if (item != null) {
	    				mCurrentSchedule = (WeekSchedule)item;
	    				mLastKnownWeek = mCurrentSchedule.getWeek().getCurrent();
						Log.i("WeekSchedule", String.format("There are %s games", mCurrentSchedule.getGames().size()));
						if ((mCurrentSchedule.getGames() != null) && !mCurrentSchedule.getGames().isEmpty()) {
	//						Collections.sort(schedule.getGames(), new GameComparator());
							if (mWeekScheduleList.getAdapter() == null) {
								mWeekScheduleAdapter = new WeekScheduleAdapter(mContext, mCurrentSchedule.getGames());
								mWeekScheduleList.setAdapter(mWeekScheduleAdapter);
							} else {
								((WeekScheduleAdapter)mWeekScheduleList.getAdapter()).refill(mCurrentSchedule.getGames());
							}
							show(Show.SCORES);
						} else {
							show(Show.EMPTY);
							mWeekScheduleList.setAdapter(null);
						}
					} else {
						Log.i("Schedule failed", "Couldn't get the schedule");
						show(Show.ERROR);
						mWeekScheduleList.setAdapter(null);
					}
				}
				
				public Context getContext() {
					return mContext;
				}
			});
	    	mWeekScheduleDownloadTask.execute(mCurrentWeek.getUrl());
    	}
    }
    
    private enum Show {
    	SCORES, LOADING, ERROR, EMPTY;
    };
    
    private void show(Show show) {
    	if (Show.SCORES.equals(show)) {
    		mStatusView.setVisibility(View.GONE);
    		mWeekScheduleList.setVisibility(View.VISIBLE);
    	} else {
    		mStatusView.setVisibility(View.VISIBLE);
    		mWeekScheduleList.setVisibility(View.GONE);
    		
    		mStatusLoadingView.setVisibility(Show.LOADING.equals(show) ? View.VISIBLE : View.GONE);
    		mStatusErrorView.setVisibility(Show.ERROR.equals(show) ? View.VISIBLE : View.GONE);
    		mStatusEmptyView.setVisibility(Show.EMPTY.equals(show) ? View.VISIBLE : View.GONE);
    	}
    }
}