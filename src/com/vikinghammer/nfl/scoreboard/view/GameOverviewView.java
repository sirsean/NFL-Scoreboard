package com.vikinghammer.nfl.scoreboard.view;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vikinghammer.nfl.scoreboard.free.R;
import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.util.NFLUtil;

public class GameOverviewView extends LinearLayout {
	
	private View mView;
	
	public GameOverviewView(Context context, AttributeSet attributes) {
		super(context, attributes);
	}
	
	public void update(Game game) {
		if (mView == null) {
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mView = (View)vi.inflate(R.layout.game_overview, this, true);
		}
		
		ImageView awayImage = (ImageView)mView.findViewById(R.id.away_image);
		awayImage.setImageDrawable(getContext().getResources().getDrawable(NFLUtil.teamLogoDrawable(game.getAwayTeam().getAbbreviation())));
		
		ImageView homeImage = (ImageView)mView.findViewById(R.id.home_image);
		homeImage.setImageDrawable(getContext().getResources().getDrawable(NFLUtil.teamLogoDrawable(game.getHomeTeam().getAbbreviation())));
		
		TextView labelView = (TextView)mView.findViewById(R.id.game_label);
		labelView.setText(String.format("%s @ %s", game.getAwayTeam().getNickname(), game.getHomeTeam().getNickname()));
		
		// show pregame info
		View pregame = mView.findViewById(R.id.pregame);
		if (!game.isFinal() && !game.isInProgress()) {
			pregame.setVisibility(View.VISIBLE);
			
			TextView datetime = (TextView)mView.findViewById(R.id.datetime);
			
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd, h:mm a");
			datetime.setText(sdf.format(game.getLocalTime().getTime()));
			
			TextView channel = (TextView)mView.findViewById(R.id.channel);
			channel.setText(game.getTvNetwork());
		} else {
			pregame.setVisibility(View.GONE);
		}
		
		// show final info
		View finalView = mView.findViewById(R.id.final_view);
		if (game.isFinal()) {
			finalView.setVisibility(View.VISIBLE);
			
			TextView awayScore = (TextView)mView.findViewById(R.id.final_away_score);
			awayScore.setText(String.format("%s", game.getAwayScore()));
			
			TextView homeScore = (TextView)mView.findViewById(R.id.final_home_score);
			homeScore.setText(String.format("%s", game.getHomeScore()));
			
			TextView finalMiddleText = (TextView)mView.findViewById(R.id.final_middle_text);
			if (5 == game.getPeriodCount()) {
				finalMiddleText.setText("OT");
			} else {
				finalMiddleText.setText("");
			}
			
			// bold the winner
			if (game.getWinner().equals(game.getHomeTeam())) {
				homeScore.setTypeface(null, Typeface.BOLD);
				homeScore.setTextColor(getContext().getResources().getColor(R.color.final_winner));
			} else {
				homeScore.setTypeface(null, Typeface.NORMAL);
				homeScore.setTextColor(getContext().getResources().getColor(R.color.final_loser));
			}
			if (game.getWinner().equals(game.getAwayTeam())) {
				awayScore.setTypeface(null, Typeface.BOLD);
				awayScore.setTextColor(getContext().getResources().getColor(R.color.final_winner));
			} else {
				awayScore.setTypeface(null, Typeface.NORMAL);
				awayScore.setTextColor(getContext().getResources().getColor(R.color.final_loser));
			}
		} else {
			finalView.setVisibility(View.GONE);
		}
		
		// show in-progress view
		View inProgressView = mView.findViewById(R.id.in_progress_view);
		if (game.isInProgress()) {
			inProgressView.setVisibility(View.VISIBLE);
			
			TextView awayScore = (TextView)mView.findViewById(R.id.in_progress_away_score);
			awayScore.setText(String.format("%s", game.getAwayScore()));
			
			TextView homeScore = (TextView)mView.findViewById(R.id.in_progress_home_score);
			homeScore.setText(String.format("%s", game.getHomeScore()));
			
			ImageView awayTimeouts = (ImageView)mView.findViewById(R.id.in_progress_away_timeouts);
			awayTimeouts.setImageDrawable(getContext().getResources().getDrawable(NFLUtil.timeoutsDrawable(game.getAwayTeamTimeoutsRemaining())));
			
			ImageView homeTimeouts = (ImageView)mView.findViewById(R.id.in_progress_home_timeouts);
			homeTimeouts.setImageDrawable(getContext().getResources().getDrawable(NFLUtil.timeoutsDrawable(game.getHomeTeamTimeoutsRemaining())));
			
			View inProgressMiddle = mView.findViewById(R.id.in_progress_middle);
			View halftimeMiddle = mView.findViewById(R.id.halftime_middle);
			
			if (game.isHalftime()) {
				inProgressMiddle.setVisibility(View.GONE);
				halftimeMiddle.setVisibility(View.VISIBLE);
			} else {
				inProgressMiddle.setVisibility(View.VISIBLE);
				halftimeMiddle.setVisibility(View.GONE);
			
				
				TextView quarterAndTime = (TextView)mView.findViewById(R.id.quarter_and_time);
				if (game.getQuarter() == 5) {
					quarterAndTime.setText(String.format("%s in %s", game.getGameClock(), game.getQuarterName()));
				} else {
					quarterAndTime.setText(String.format("%s in the %s", game.getGameClock(), game.getQuarterName()));
				}
				
				TextView downAndDistance = (TextView)mView.findViewById(R.id.down_and_distance);
				downAndDistance.setText(String.format("%s and %s", game.getDownName(), game.getYardsToGo()));
				
				View awayChevron = mView.findViewById(R.id.away_possession_chevron);
				View homeChevron = mView.findViewById(R.id.home_possession_chevron);
				
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
	}

}
