package com.vikinghammer.nfl.scoreboard.parse;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vikinghammer.nfl.scoreboard.model.AllWeeks;
import com.vikinghammer.nfl.scoreboard.model.WeekInfo;

public class AllWeeksTest extends TestCase {

	private String json = "{\"current\":{\"season\":2011,\"week\":11,\"type\":\"reg\",\"weekName\":\"Week 11\"},\"content\":[{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":1,\"weekName\":\"Week 1\",\"weekNumber\":1},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":2,\"weekName\":\"Week 2\",\"weekNumber\":2},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":3,\"weekName\":\"Week 3\",\"weekNumber\":3},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":4,\"weekName\":\"Week 4\",\"weekNumber\":4},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":5,\"weekName\":\"Week 5\",\"weekNumber\":5},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":6,\"weekName\":\"Week 6\",\"weekNumber\":6},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":7,\"weekName\":\"Week 7\",\"weekNumber\":7},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":8,\"weekName\":\"Week 8\",\"weekNumber\":8},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":9,\"weekName\":\"Week 9\",\"weekNumber\":9},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":10,\"weekName\":\"Week 10\",\"weekNumber\":10},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":11,\"weekName\":\"Week 11\",\"weekNumber\":11},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":12,\"weekName\":\"Week 12\",\"weekNumber\":12},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":13,\"weekName\":\"Week 13\",\"weekNumber\":13},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":14,\"weekName\":\"Week 14\",\"weekNumber\":14},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":15,\"weekName\":\"Week 15\",\"weekNumber\":15},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":16,\"weekName\":\"Week 16\",\"weekNumber\":16},{\"season\":2011,\"seasonType\":\"reg\",\"type\":\"reg\",\"week\":17,\"weekName\":\"Week 17\",\"weekNumber\":17}],\"nbPreSeasonGames\":0,\"nbOffSeasonGames\":0,\"same\":false,\"__cmde__\":\"allWeeks.js\",\"__processing_ms__\":\"11\"}";
	
	public void testParse() {
		Gson gson = new GsonBuilder().create();
		AllWeeks allWeeks = gson.fromJson(json, AllWeeks.class);
		
		assertNotNull(allWeeks);
		
		WeekInfo current = allWeeks.getCurrent();
		assertNotNull(current);
		assertEquals(2011, current.getSeason());
		assertEquals(11, current.getWeek());
		assertEquals("reg", current.getType());
		assertEquals("Week 11", current.getWeekName());
		assertEquals("http://s3.amazonaws.com/nflgc/week_reg_11_schedule.js", current.getUrl());
	}
}
