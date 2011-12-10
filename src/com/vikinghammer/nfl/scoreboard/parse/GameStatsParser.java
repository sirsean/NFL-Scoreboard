package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.stat.GameStats;

public class GameStatsParser {
	
	public GameStats parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(reader, GameStats.class);
	}

}
