package com.vikinghammer.nfl.scoreboard.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.vikinghammer.nfl.scoreboard.free.R;
import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.view.GameOverviewView;

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
		
		GameOverviewView gameOverview = (GameOverviewView)gameView.findViewById(R.id.game_overview);
		gameOverview.update(game);
		
		return gameView;
	}
	
}
