package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.Game;
import com.vikinghammer.nfl.scoreboard.model.GameWrapper;

public class GameParser {

	public Game parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		GameWrapper wrapper = mapper.readValue(reader, GameWrapper.class);
		return wrapper.getGame();
	}
	
}
