package com.vikinghammer.nfl.scoreboard.task;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.parse.GameParser;

public class GameDownloadTask extends AsyncTask<String, String, Game> {

	private AsyncTaskListener mListener;
	
	public GameDownloadTask(AsyncTaskListener listener) {
		mListener = listener;
	}
	
	@Override
	protected Game doInBackground(String... requestStrings) {
		for (String requestString : requestStrings) {
			if (requestString == null) {
				continue;
			}
			
			try {
				URL url = new URL(requestString);
				InputStream inputStream = url.openConnection().getInputStream();
				Reader reader = new InputStreamReader(inputStream);
				if (!isCancelled()) {
					GameParser parser = new GameParser();
					return parser.parse(reader);
				}
			} catch (Throwable t) {
				Log.e("FAIL", t.getMessage(), t);
			}
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(final Game game) {
		mListener.onComplete(game);
	}
}
