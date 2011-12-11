package com.vikinghammer.nfl.scoreboard.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vikinghammer.nfl.scoreboard.free.R;
import com.vikinghammer.nfl.scoreboard.model.pbp.Play;
import com.vikinghammer.nfl.scoreboard.model.pbp.PlayByPlay;

public class PlayByPlayAdapter extends BaseAdapter {
	
	private Context mContext;
	private List<Play> mPlays;
	
	public PlayByPlayAdapter(Context context, PlayByPlay playByPlay) {
		super();
		mContext = context;
		
		mPlays = new ArrayList<Play>();
		mPlays.addAll(playByPlay.getAllPlays());
		Collections.reverse(mPlays);
	}
	
	public void refill(PlayByPlay pbp) {
		mPlays.clear();
		mPlays.addAll(pbp.getAllPlays());
		Collections.reverse(mPlays);
		notifyDataSetChanged();
	}

	public int getCount() {
		if (mPlays != null) {
			return mPlays.size();
		} else {
			return 0;
		}
	}

	public Object getItem(int arg0) {
		if (mPlays != null) {
			return mPlays.get(arg0);
		} else {
			return null;
		}
	}

	public long getItemId(int arg0) {
		if (mPlays != null) {
			return mPlays.get(arg0).getInternalId();
		} else {
			return 0;
		}
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout playView;
		if (convertView == null) {
			playView = new LinearLayout(mContext);
			LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi.inflate(R.layout.play_by_play_item, playView);
		} else {
			playView = (LinearLayout) convertView;
		}
		
		Play play = mPlays.get(position);
		
		TextView descriptionView = (TextView)playView.findViewById(R.id.pbp_description);
		
		if (play != null) {
			descriptionView.setText(play.getDescriptionShort());
			
			if (play.isScoringPlay()) {
				descriptionView.setTextColor(mContext.getResources().getColor(R.color.pbp_scoring));
			} else {
				descriptionView.setTextColor(mContext.getResources().getColor(R.color.pbp_normal));
			}
		} else {
			descriptionView.setText("");
			descriptionView.setTextColor(mContext.getResources().getColor(R.color.final_loser));
		}
		
		return playView;
	}

}
