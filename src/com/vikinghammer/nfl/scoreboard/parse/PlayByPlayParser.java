package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.pbp.PlayByPlay;

public class PlayByPlayParser {
	
	public PlayByPlay parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(reader, PlayByPlay.class);
	}

}
