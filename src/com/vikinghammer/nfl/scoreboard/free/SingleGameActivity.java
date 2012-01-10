package com.vikinghammer.nfl.scoreboard.free;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.vikinghammer.event.EventRecorder;
import com.vikinghammer.nfl.scoreboard.adapter.PlayByPlayAdapter;
import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.model.pbp.PlayByPlay;
import com.vikinghammer.nfl.scoreboard.task.AsyncTaskListener;
import com.vikinghammer.nfl.scoreboard.task.GameDownloadTask;
import com.vikinghammer.nfl.scoreboard.task.PlayByPlayDownloadTask;
import com.vikinghammer.nfl.scoreboard.util.NFLUtil;
import com.vikinghammer.nfl.scoreboard.view.GameOverviewView;

public class SingleGameActivity extends Activity {
	
	private Context mContext = this;
	
	private String mGameId;
	
	private GameOverviewView gameOverviewView;
	
	private View playByPlayView;
	
	private View loadingView;
	private View errorView;
	private View emptyView;
	
	private GameDownloadTask mGameDownloadTask;
	private PlayByPlayDownloadTask mPlayByPlayDownloadTask;
	
	private ListView mPlayByPlayList;
	
	private Button mRefreshButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.single_game);
		
		Bundle extras = getIntent().getExtras();
		mGameId = extras.getString(Game.GAME_ID);
		
		gameOverviewView = (GameOverviewView)findViewById(R.id.game_overview);
		
		playByPlayView = findViewById(R.id.single_game_play_by_play_view);
		loadingView = findViewById(R.id.loading_view);
		errorView = findViewById(R.id.error_view);
		emptyView = findViewById(R.id.empty_view);
		
		mPlayByPlayList = (ListView)findViewById(R.id.play_by_play_list);
		
		mRefreshButton = (Button)findViewById(R.id.refresh_button);
		
		mRefreshButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EventRecorder.record(mContext, "refresh", mGameId);
				downloadGame();
				downloadPlayByPlay();
			}
		});
		
		Log.i("SingleGame", mGameId);
		
		show(Show.LOADING);
		downloadGame();
		downloadPlayByPlay();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		EventRecorder.record(this, "single-game-opened", mGameId);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		EventRecorder.record(this, "single-game-closed", mGameId);
	}
	
	private enum Show {
		PBP, LOADING, ERROR, EMPTY
	};
	
	private void show(Show show) {
		playByPlayView.setVisibility(Show.PBP.equals(show) ? View.VISIBLE : View.GONE);
		loadingView.setVisibility(Show.LOADING.equals(show) ? View.VISIBLE : View.GONE);
		errorView.setVisibility(Show.ERROR.equals(show) ? View.VISIBLE : View.GONE);
		emptyView.setVisibility(Show.EMPTY.equals(show) ? View.VISIBLE : View.GONE);
	}
	
	private void downloadGame() {
		if (mGameId != null) {
			mGameDownloadTask = new GameDownloadTask(new AsyncTaskListener() {
				public void onComplete(Object item) {
					if (item != null) {
						Log.i("Game downloaded", "Game download finished");
						Game game = (Game)item;
						gameOverviewView.update(game);
					} else {
						Log.i("Game failed", "Couldn't download the game");
					}
				}
				
				public Context getContext() {
					return mContext;
				}
			});
			mGameDownloadTask.execute(NFLUtil.getGameUrl(mGameId));
		}
	}
	
	private void downloadPlayByPlay() {
		if (mGameId != null) {
			mPlayByPlayDownloadTask = new PlayByPlayDownloadTask(new AsyncTaskListener() {
				public void onComplete(Object item) {
					if (item != null) {
						Log.i("PBP downloaded", "Got the play by play");
						PlayByPlay playByPlay = (PlayByPlay)item;
						if (mPlayByPlayList.getAdapter() == null) {
							PlayByPlayAdapter pbpAdapter = new PlayByPlayAdapter(mContext, playByPlay);
							mPlayByPlayList.setAdapter(pbpAdapter);
						} else {
							((PlayByPlayAdapter)mPlayByPlayList.getAdapter()).refill(playByPlay);
						}
						
						if (((PlayByPlayAdapter)mPlayByPlayList.getAdapter()).getCount() <= 0) {
							show(Show.EMPTY);
						} else {
							show(Show.PBP);
						}
			
					} else {
						Log.i("PBP failed", "Couldn't download the play by play");
						show(Show.ERROR);
					}
				}
				
				public Context getContext() {
					return mContext;
				}
			});
			mPlayByPlayDownloadTask.execute(NFLUtil.getPlayByPlayUrl(mGameId));
		}
	}

}
