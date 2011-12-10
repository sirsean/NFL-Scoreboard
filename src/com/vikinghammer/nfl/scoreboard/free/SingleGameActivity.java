package com.vikinghammer.nfl.scoreboard.free;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.vikinghammer.nfl.scoreboard.model.Game;

public class SingleGameActivity extends Activity {
	
	private Context mContext = this;
	
	private String mGameId;
	
	private View gameInfoView;
	private View playByPlayView;
	private View statsView;
	
	private Button gameInfoButton;
	private Button playByPlayButton;
	private Button statsButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.single_game);
		
		Bundle extras = getIntent().getExtras();
		mGameId = extras.getString(Game.GAME_ID);
		
		TextView textView = (TextView)findViewById(R.id.fake);
		textView.setText(mGameId);
		
		gameInfoView = findViewById(R.id.single_game_info_view);
		playByPlayView = findViewById(R.id.single_game_play_by_play_view);
		statsView = findViewById(R.id.single_game_stats_view);
		
		gameInfoButton = (Button)findViewById(R.id.single_game_info_button);
		playByPlayButton = (Button)findViewById(R.id.single_game_play_by_play_button);
		statsButton = (Button)findViewById(R.id.single_game_stats_button);
		
		gameInfoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				show(Show.GAME_INFO);
			}
		});
		playByPlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				show(Show.PLAY_BY_PLAY);
			}
		});
		statsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				show(Show.STATS);
			}
		});
		
		Log.i("SingleGame", mGameId);
	}
	
	private enum Show {
		GAME_INFO, PLAY_BY_PLAY, STATS
	};
	
	private void show(Show show) {
		gameInfoView.setVisibility(Show.GAME_INFO.equals(show) ? View.VISIBLE : View.GONE);
		playByPlayView.setVisibility(Show.PLAY_BY_PLAY.equals(show) ? View.VISIBLE : View.GONE);
		statsView.setVisibility(Show.STATS.equals(show) ? View.VISIBLE : View.GONE);
	}

}
