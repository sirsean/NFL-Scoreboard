package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.WeekSchedule;

public class WeekScheduleParser {
	
	public WeekSchedule parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		WeekSchedule schedule = mapper.readValue(reader, WeekSchedule.class);
		return schedule;
	}

}
