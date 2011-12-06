package com.vikinghammer.nfl.scoreboard.task;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

import com.vikinghammer.nfl.scoreboard.model.AllWeeks;
import com.vikinghammer.nfl.scoreboard.parse.AllWeeksParser;

public class AllWeeksDownloadTask extends AsyncTask<String, String, AllWeeks> {
	
	private AsyncTaskListener mListener;
	
	public AllWeeksDownloadTask(AsyncTaskListener listener) {
		mListener = listener;
	}
	
	@Override
	protected AllWeeks doInBackground(String... requestStrings) {
		for (String requestString : requestStrings) {
			if (requestString == null) {
				continue;
			}
			
			try {
				URL url = new URL(requestString);
				InputStream inputStream = url.openConnection().getInputStream();
				Reader reader = new InputStreamReader(inputStream);
				if (!isCancelled()) {
					AllWeeksParser parser = new AllWeeksParser();
					return parser.parse(reader);
				}
			} catch (Throwable t) {
				Log.e("FAIL", t.getMessage(), t);
			}
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(final AllWeeks allWeeks) {
		mListener.onComplete(allWeeks);
	}

}
