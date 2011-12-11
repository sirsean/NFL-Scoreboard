package com.vikinghammer.nfl.scoreboard.task;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

import com.vikinghammer.nfl.scoreboard.model.pbp.PlayByPlay;
import com.vikinghammer.nfl.scoreboard.parse.PlayByPlayParser;

public class PlayByPlayDownloadTask extends AsyncTask<String, String, PlayByPlay> {

	private AsyncTaskListener mListener;
	
	public PlayByPlayDownloadTask(AsyncTaskListener listener) {
		mListener = listener;
	}
	
	@Override
	protected PlayByPlay doInBackground(String... requestStrings) {
		for (String requestString : requestStrings) {
			if (requestString == null) {
				continue;
			}
			
			try {
				URL url = new URL(requestString);
				InputStream inputStream = url.openConnection().getInputStream();
				Reader reader = new InputStreamReader(inputStream);
				if (!isCancelled()) {
					PlayByPlayParser parser = new PlayByPlayParser();
					return parser.parse(reader);
				}
			} catch (Throwable t) {
				Log.e("FAIL", t.getMessage(), t);
			}
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(final PlayByPlay pbp) {
		mListener.onComplete(pbp);
	}
}
