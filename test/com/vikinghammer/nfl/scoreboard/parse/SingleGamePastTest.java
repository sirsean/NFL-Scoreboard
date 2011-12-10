package com.vikinghammer.nfl.scoreboard.parse;

import java.io.StringReader;

import junit.framework.TestCase;

import com.vikinghammer.nfl.scoreboard.model.Game;

public class SingleGamePastTest extends TestCase {
	
	private String json = "{\"gameId\":\"2011102311\",\"content\":{\"id\":\"2011102311\",\"label\":\"IND @ NO\",\"gameClock\":\":00\",\"possessionTeam\":{},\"seasonType\":\"reg\",\"stadium\":\"Mercedes-Benz Superdome\",\"status\":\"Final\",\"tvNetwork\":\"NBC\",\"insideTwenty\":false,\"isFinal\":true,\"isHalftime\":false,\"isInProgress\":false,\"isPreGame\":false,\"periodCount\":4,\"season\":2011,\"weekNumber\":7,\"crossedRedZone\":false,\"dateTime\":\"2011-10-23T17:20:00.000-07:00\",\"dateTime_time\":\"8:20 PM ET\",\"dateTime_date\":\"Sun, Oct 23\",\"hasJustScored\":false,\"weather\":\"Dome\",\"temperatures\":\"Dome\",\"conditions\":\"Dome\",\"preview\":{},\"recap\":{},\"winner\":{\"id\":\"3300\",\"name\":\"New Orleans Saints\",\"nickName\":\"Saints\",\"abbreviation\":\"NO\",\"city\":\"New Orleans\",\"conference\":\"NFC\",\"division\":\"South\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_no.png\",\"draftNeeds\":\"LB,DL,S,OL\"},\"awayTeam\":{\"id\":\"2200\",\"name\":\"Indianapolis Colts\",\"nickName\":\"Colts\",\"abbreviation\":\"IND\",\"city\":\"Indianapolis\",\"conference\":\"AFC\",\"division\":\"South\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\":\"OL,DL,S,SPEC,CB\"},\"awayScore\":7,\"awayQ1Score\":0,\"awayQ2Score\":7,\"awayQ3Score\":0,\"awayQ4Score\":0,\"awayOtScore\":0,\"awayTeamTimeoutsRemaining\":3,\"awayTeamScores\":[],\"awayTeamRecord\":\"0-7-0\",\"homeTeam\":{\"id\":\"3300\",\"name\":\"New Orleans Saints\",\"nickName\":\"Saints\",\"abbreviation\":\"NO\",\"city\":\"New Orleans\",\"conference\":\"NFC\",\"division\":\"South\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_no.png\",\"draftNeeds\":\"LB,DL,S,OL\"},\"homeScore\":62,\"homeQ1Score\":21,\"homeQ2Score\":13,\"homeQ3Score\":14,\"homeQ4Score\":14,\"homeOtScore\":0,\"homeTeamTimeoutsRemaining\":3,\"homeTeamScores\":[],\"homeTeamRecord\":\"5-2-0\",\"gameKey\":\"55265\"},\"same\":false,\"__cmde__\":\"game.js\",\"__processing_ms__\":\"21\"}";
	
	public void testParse() throws Exception {
		GameParser parser = new GameParser();
		Game game = parser.parse(new StringReader(json));
		
		assertNotNull(game);
		assertEquals("2011102311", game.getGameId());
		assertEquals("IND @ NO", game.getLabel());
		assertEquals(":00", game.getGameClock());
		assertEquals("Final", game.getStatus());
		assertEquals("NBC", game.getTvNetwork());
		assertFalse(game.isCrossedRedZone());
		assertFalse(game.isHalftime());
		assertFalse(game.isInProgress());
		assertFalse(game.isInsideTwenty());
		assertFalse(game.isJustScored());
		assertFalse(game.isPreGame());
		assertTrue(game.isFinal());
		assertEquals(4, game.getPeriodCount());
		
		assertNotNull(game.getWinner());
		assertEquals("New Orleans Saints", game.getWinner().getName());
		
		assertNotNull(game.getAwayTeam());
		assertEquals("Indianapolis Colts", game.getAwayTeam().getName());
		
		assertNotNull(game.getHomeTeam());
		assertEquals("New Orleans Saints", game.getHomeTeam().getName());
		
		assertEquals(7, game.getAwayScore());
		assertEquals(0, game.getAwayQ1Score());
		assertEquals(7, game.getAwayQ2Score());
		assertEquals(0, game.getAwayQ3Score());
		assertEquals(0, game.getAwayQ4Score());
		assertEquals(0, game.getAwayOtScore());
		assertEquals(3, game.getAwayTeamTimeoutsRemaining());
		assertEquals("0-7-0", game.getAwayTeamRecord());
		
		assertEquals(62, game.getHomeScore());
		assertEquals(21, game.getHomeQ1Score());
		assertEquals(13, game.getHomeQ2Score());
		assertEquals(14, game.getHomeQ3Score());
		assertEquals(14, game.getHomeQ4Score());
		assertEquals(0, game.getHomeOtScore());
		assertEquals(3, game.getHomeTeamTimeoutsRemaining());
		assertEquals("5-2-0", game.getHomeTeamRecord());
	}

}
