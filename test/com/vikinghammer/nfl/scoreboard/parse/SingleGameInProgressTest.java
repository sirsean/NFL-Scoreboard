package com.vikinghammer.nfl.scoreboard.parse;

import java.io.StringReader;

import junit.framework.TestCase;

import com.vikinghammer.nfl.scoreboard.model.Game;

public class SingleGameInProgressTest extends TestCase {
	
	private String json = "{\"gameId\":\"2011121103\",\"content\":{\"id\":\"2011121103\",\"label\":\"HOU @ CIN\",\"down\":1,\"gameClock\":\"11:48\",\"possessionTeam\":{\"id\":\"2120\",\"name\":\"Houston Texans\",\"nickName\":\"Texans\",\"abbreviation\":\"HOU\",\"city\":\"Houston\",\"conference\":\"AFC\",\"division\":\"South\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_hou.png\",\"draftNeeds\":\"CB,DL,LB,S\"},\"hasPossession\":\"away\",\"quarter\":1,\"seasonType\":\"reg\",\"stadium\":\"Paul Brown Stadium\",\"status\":\"1\",\"tvNetwork\":\"CBS\",\"insideTwenty\":false,\"isFinal\":false,\"isHalftime\":false,\"isInProgress\":true,\"isPreGame\":false,\"periodCount\":4,\"season\":2011,\"weekNumber\":14,\"yardLine\":\"CIN 32\",\"yardsFromGoal\":32,\"yardsToGo\":10,\"crossedRedZone\":false,\"dateTime\":\"2011-12-11T10:00:00.000-08:00\",\"dateTime_time\":\"1:00 PM ET\",\"dateTime_date\":\"Sun, Dec 11\",\"hasJustScored\":false,\"weather\":\"Sunny Temp: 34  F, Wind: SSW 5 mph\",\"temperatures\":\"Sunny: 34F\",\"conditions\":\"Wind: SSW 5 mph\",\"preview\":{},\"recap\":{},\"winner\":{},\"awayTeam\":{\"id\":\"2120\",\"name\":\"Houston Texans\",\"nickName\":\"Texans\",\"abbreviation\":\"HOU\",\"city\":\"Houston\",\"conference\":\"AFC\",\"division\":\"South\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_hou.png\",\"draftNeeds\":\"CB,DL,LB,S\"},\"awayScore\":0,\"awayQ1Score\":0,\"awayQ2Score\":0,\"awayQ3Score\":0,\"awayQ4Score\":0,\"awayOtScore\":0,\"awayTeamTimeoutsRemaining\":3,\"awayTeamScores\":[],\"awayTeamRecord\":\"9-3-0\",\"homeTeam\":{\"id\":\"0920\",\"name\":\"Cincinnati Bengals\",\"nickName\":\"Bengals\",\"abbreviation\":\"CIN\",\"city\":\"Cincinnati\",\"conference\":\"AFC\",\"division\":\"North\",\"imageUrl\":\"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_cin.png\",\"draftNeeds\":\"QB,S,LB,DL,RB,WR\"},\"homeScore\":0,\"homeQ1Score\":0,\"homeQ2Score\":0,\"homeQ3Score\":0,\"homeQ4Score\":0,\"homeOtScore\":0,\"homeTeamTimeoutsRemaining\":3,\"homeTeamScores\":[],\"homeTeamRecord\":\"7-5-0\",\"gameKey\":\"55359\"},\"same\":false,\"__cmde__\":\"game.js\",\"__processing_ms__\":\"11\"}";
	
	public void testParse() throws Exception {
		GameParser parser = new GameParser();
		Game game = parser.parse(new StringReader(json));
		
		assertNotNull(game);
	}

}
