package com.vikinghammer.nfl.scoreboard.date;

import java.util.Calendar;
import java.util.TimeZone;

public class LocalTimeCalculator {
	
	private String mTime;
	private String mAmpm;
	
	public LocalTimeCalculator(String time, String ampm) {
		mTime = time;
		mAmpm = ampm;
	}
	
	public Calendar getLocalTime() {
		String[] timeArray = mTime.split(":");
		int hour = Integer.parseInt(timeArray[0]);
		int minute = Integer.parseInt(timeArray[1]);
		
		hour = convertToHourOfDay(hour, mAmpm);
		
		Calendar eastern = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		eastern.set(Calendar.HOUR_OF_DAY, hour);
		//eastern.set(Calendar.AM_PM, "AM".equals(mAmpm) ? Calendar.AM : Calendar.PM);
		eastern.set(Calendar.MINUTE, minute);
		
		Calendar local = Calendar.getInstance();
		local.setTimeInMillis(eastern.getTimeInMillis());
		
		return local;
	}

	private int convertToHourOfDay(int hour, String ampm) {
		if ("AM".equalsIgnoreCase(ampm)) {
			if (hour == 12) {
				return 0;
			} else {
				return hour;
			}
		} else {
			if (hour == 12) {
				return 12;
			} else {
				return hour + 12;
			}
		}
	}
}
