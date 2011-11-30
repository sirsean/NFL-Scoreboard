package com.vikinghammer.nfl.scoreboard.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vikinghammer.nfl.scoreboard.free.R;
import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.util.NFLUtil;

public class WeekScheduleAdapter extends BaseAdapter {
	
	private Context mContext;
	private List<Game> mGames;
	
	public WeekScheduleAdapter(Context context, List<Game> games) {
		mContext = context;
		mGames = games;
	}
	
	public void refill(List<Game> games) {
		mGames.clear();
		mGames.addAll(games);
		notifyDataSetChanged();
	}
	
	public int getCount() {
		if (mGames != null) {
			return mGames.size();
		} else {
			return 0;
		}
	}
	
	public Object getItem(int index) {
		if (mGames != null) {
			return mGames.get(index);
		} else {
			return null;
		}
	}
	
	public long getItemId(int index) {
		if (mGames != null) {
			return mGames.get(index).getInternalId();
		} else {
			return -1L;
		}
	}
	
	public View getView(int index, View view, ViewGroup viewGroup) {
		LinearLayout gameView;
		if (view == null) {
			gameView = new LinearLayout(mContext);
			LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi.inflate(R.layout.main_list_item, gameView);
		} else {
			gameView = (LinearLayout) view;
		}
		
		Game game = mGames.get(index);
		
		ImageView awayImage = (ImageView)gameView.findViewById(R.id.away_image);
		awayImage.setImageDrawable(mContext.getResources().getDrawable(NFLUtil.teamLogoDrawable(game.getAwayTeam().getAbbreviation())));
		
		ImageView homeImage = (ImageView)gameView.findViewById(R.id.home_image);
		homeImage.setImageDrawable(mContext.getResources().getDrawable(NFLUtil.teamLogoDrawable(game.getHomeTeam().getAbbreviation())));
		
		TextView labelView = (TextView)gameView.findViewById(R.id.game_label);
		labelView.setText(String.format("%s @ %s", game.getAwayTeam().getNickname(), game.getHomeTeam().getNickname()));
		
		// show pregame info
		View pregame = gameView.findViewById(R.id.pregame);
		if (!game.isFinal() && !game.isInProgress()) {
			pregame.setVisibility(View.VISIBLE);
			
			TextView datetime = (TextView)gameView.findViewById(R.id.datetime);
			
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd, h:mm a");
			datetime.setText(sdf.format(game.getLocalTime().getTime()));
			
			TextView channel = (TextView)gameView.findViewById(R.id.channel);
			channel.setText(game.getTvNetwork());
		} else {
			pregame.setVisibility(View.GONE);
		}
		
		// show final info
		View finalView = gameView.findViewById(R.id.final_view);
		if (game.isFinal()) {
			finalView.setVisibility(View.VISIBLE);
			
			TextView awayScore = (TextView)gameView.findViewById(R.id.final_away_score);
			awayScore.setText(String.format("%s", game.getAwayScore()));
			
			TextView homeScore = (TextView)gameView.findViewById(R.id.final_home_score);
			homeScore.setText(String.format("%s", game.getHomeScore()));
			
			TextView finalMiddleText = (TextView)gameView.findViewById(R.id.final_middle_text);
			if (5 == game.getPeriodCount()) {
				finalMiddleText.setText("OT");
			} else {
				finalMiddleText.setText("");
			}
			
			// bold the winner
			if (game.getWinner().equals(game.getHomeTeam())) {
				homeScore.setTypeface(null, Typeface.BOLD);
				homeScore.setTextColor(mContext.getResources().getColor(R.color.final_winner));
			} else {
				homeScore.setTypeface(null, Typeface.NORMAL);
				homeScore.setTextColor(mContext.getResources().getColor(R.color.final_loser));
			}
			if (game.getWinner().equals(game.getAwayTeam())) {
				awayScore.setTypeface(null, Typeface.BOLD);
				awayScore.setTextColor(mContext.getResources().getColor(R.color.final_winner));
			} else {
				awayScore.setTypeface(null, Typeface.NORMAL);
				awayScore.setTextColor(mContext.getResources().getColor(R.color.final_loser));
			}
		} else {
			finalView.setVisibility(View.GONE);
		}
		
		// show in-progress view
		View inProgressView = gameView.findViewById(R.id.in_progress_view);
		if (game.isInProgress()) {
			inProgressView.setVisibility(View.VISIBLE);
			
			TextView awayScore = (TextView)gameView.findViewById(R.id.in_progress_away_score);
			awayScore.setText(String.format("%s", game.getAwayScore()));
			
			TextView homeScore = (TextView)gameView.findViewById(R.id.in_progress_home_score);
			homeScore.setText(String.format("%s", game.getHomeScore()));
			
			ImageView awayTimeouts = (ImageView)gameView.findViewById(R.id.in_progress_away_timeouts);
			awayTimeouts.setImageDrawable(mContext.getResources().getDrawable(timeoutsImages[game.getAwayTeamTimeoutsRemaining()]));
			
			ImageView homeTimeouts = (ImageView)gameView.findViewById(R.id.in_progress_home_timeouts);
			homeTimeouts.setImageDrawable(mContext.getResources().getDrawable(timeoutsImages[game.getHomeTeamTimeoutsRemaining()]));
			
			View inProgressMiddle = gameView.findViewById(R.id.in_progress_middle);
			View halftimeMiddle = gameView.findViewById(R.id.halftime_middle);
			
			if (game.isHalftime()) {
				inProgressMiddle.setVisibility(View.GONE);
				halftimeMiddle.setVisibility(View.VISIBLE);
			} else {
				inProgressMiddle.setVisibility(View.VISIBLE);
				halftimeMiddle.setVisibility(View.GONE);
			
				
				TextView quarterAndTime = (TextView)gameView.findViewById(R.id.quarter_and_time);
				if (game.getQuarter() == 5) {
					quarterAndTime.setText(String.format("%s in %s", game.getGameClock(), game.getQuarterName()));
				} else {
					quarterAndTime.setText(String.format("%s in the %s", game.getGameClock(), game.getQuarterName()));
				}
				
				TextView downAndDistance = (TextView)gameView.findViewById(R.id.down_and_distance);
				downAndDistance.setText(String.format("%s and %s", game.getDownName(), game.getYardsToGo()));
				
				View awayChevron = gameView.findViewById(R.id.away_possession_chevron);
				View homeChevron = gameView.findViewById(R.id.home_possession_chevron);
				
				if ("away".equals(game.getHasPossession())) {
					awayChevron.setVisibility(View.VISIBLE);
					homeChevron.setVisibility(View.INVISIBLE);
				} else if ("home".equals(game.getHasPossession())) {
					homeChevron.setVisibility(View.VISIBLE);
					awayChevron.setVisibility(View.INVISIBLE);
				} else {
					awayChevron.setVisibility(View.GONE);
					homeChevron.setVisibility(View.INVISIBLE);
				}
			}
			
		} else {
			inProgressView.setVisibility(View.GONE);
		}
		
		return gameView;
	}
	
	private int[] timeoutsImages = new int[] {
		R.drawable.timeouts_0,
		R.drawable.timeouts_1,
		R.drawable.timeouts_2,
		R.drawable.timeouts_3
	};

}
