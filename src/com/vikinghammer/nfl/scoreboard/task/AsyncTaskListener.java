package com.vikinghammer.nfl.scoreboard.task;

import android.content.Context;

public interface AsyncTaskListener {
	
	public Context getContext();
	
	public void onComplete(Object item);

}
