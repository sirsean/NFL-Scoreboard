package com.vikinghammer.nfl.scoreboard.parse;

import java.io.StringReader;

import junit.framework.TestCase;

import com.vikinghammer.nfl.scoreboard.model.pbp.CurrentDrive;
import com.vikinghammer.nfl.scoreboard.parse.CurrentDriveParser;

public class CurrentDriveTest extends TestCase {
	
	private String json = "{\"gameId\" : \"2011102311\",\"content\" : [{\"id\" : \"3676\",\"playType\" : \"PUNT_OR_KICK\",\"clockTime\" : \"2:56\",\"descriptionShort\" : \"(2:56) 6-T.Morstead punts 53 yards to IND 16, Center-47-J.Drescher.\",\"down\" : 4,\"isScoringPlay\" : false,\"netYards\" : 53,\"onOpponentSide\" : false,\"quarter\" : 4,\"yardLine\" : \"NO 31\",\"yardLineBefore\" : 31,\"yardsFromGoal\" : 69,\"yardsToGo\" : 1,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"3300\",\"name\" : \"New Orleans Saints\",\"nickName\" : \"Saints\",\"abbreviation\" : \"NO\",\"city\" : \"New Orleans\",\"conference\" : \"NFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_no.png\",\"draftNeeds\" : \"LB,DL,S,OL\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3676a\",\"playType\" : \"RUSH\",\"clockTime\" : \"2:56\",\"descriptionShort\" : \"15-B.White pushed ob at IND 29 for 13 yards (53-R.Humber).\",\"down\" : 4,\"isScoringPlay\" : false,\"netYards\" : 13,\"onOpponentSide\" : false,\"quarter\" : 4,\"yardLine\" : \"IND 16\",\"yardLineBefore\" : 16,\"yardsFromGoal\" : 84,\"yardsToGo\" : 0,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"2200\",\"name\" : \"Indianapolis Colts\",\"nickName\" : \"Colts\",\"abbreviation\" : \"IND\",\"city\" : \"Indianapolis\",\"conference\" : \"AFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\" : \"OL,DL,S,SPEC,CB\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3702\",\"playType\" : \"RUSH\",\"clockTime\" : \"2:44\",\"descriptionShort\" : \"(2:44) 31-D.Brown right end to IND 30 for 1 yard (95-M.Wilson).\",\"down\" : 1,\"isScoringPlay\" : false,\"netYards\" : 1,\"onOpponentSide\" : false,\"quarter\" : 4,\"yardLine\" : \"IND 29\",\"yardLineBefore\" : 29,\"yardsFromGoal\" : 71,\"yardsToGo\" : 10,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"2200\",\"name\" : \"Indianapolis Colts\",\"nickName\" : \"Colts\",\"abbreviation\" : \"IND\",\"city\" : \"Indianapolis\",\"conference\" : \"AFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\" : \"OL,DL,S,SPEC,CB\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3723\",\"playType\" : \"UNKNOWN\",\"clockTime\" : \"2:00\",\"descriptionShort\" : \"Two-Minute Warning\",\"down\" : 0,\"isScoringPlay\" : false,\"netYards\" : 0,\"quarter\" : 4,\"yardsToGo\" : 0,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3740\",\"playType\" : \"RUSH\",\"clockTime\" : \"2:00\",\"descriptionShort\" : \"(2:00) 31-D.Brown left guard to IND 30 for no gain (92-S.Rogers).\",\"down\" : 2,\"isScoringPlay\" : false,\"netYards\" : 0,\"onOpponentSide\" : false,\"quarter\" : 4,\"yardLine\" : \"IND 30\",\"yardLineBefore\" : 30,\"yardsFromGoal\" : 70,\"yardsToGo\" : 9,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"2200\",\"name\" : \"Indianapolis Colts\",\"nickName\" : \"Colts\",\"abbreviation\" : \"IND\",\"city\" : \"Indianapolis\",\"conference\" : \"AFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\" : \"OL,DL,S,SPEC,CB\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3761\",\"playType\" : \"RUSH\",\"clockTime\" : \"1:17\",\"descriptionShort\" : \"(1:17) 31-D.Brown left end to NO 46 for 24 yards (40-J.Amaya).\",\"down\" : 3,\"isScoringPlay\" : false,\"netYards\" : 24,\"onOpponentSide\" : false,\"quarter\" : 4,\"yardLine\" : \"IND 30\",\"yardLineBefore\" : 30,\"yardsFromGoal\" : 70,\"yardsToGo\" : 9,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"2200\",\"name\" : \"Indianapolis Colts\",\"nickName\" : \"Colts\",\"abbreviation\" : \"IND\",\"city\" : \"Indianapolis\",\"conference\" : \"AFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\" : \"OL,DL,S,SPEC,CB\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3782\",\"playType\" : \"RUSH\",\"clockTime\" : \":31\",\"descriptionShort\" : \"(:31) 31-D.Brown right guard to NO 36 for 10 yards (40-J.Amaya; 52-J.Casillas).\",\"down\" : 1,\"isScoringPlay\" : false,\"netYards\" : 10,\"onOpponentSide\" : true,\"quarter\" : 4,\"yardLine\" : \"NO 46\",\"yardLineBefore\" : 46,\"yardsFromGoal\" : 46,\"yardsToGo\" : 10,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {\"id\" : \"2200\",\"name\" : \"Indianapolis Colts\",\"nickName\" : \"Colts\",\"abbreviation\" : \"IND\",\"city\" : \"Indianapolis\",\"conference\" : \"AFC\",\"division\" : \"South\",\"imageUrl\" : \"http://s3.amazonaws.com/nflgc-images/ws/team_icons/icon_team_ind.png\",\"draftNeeds\" : \"OL,DL,S,SPEC,CB\"},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}},{\"id\" : \"3803\",\"playType\" : \"UNKNOWN\",\"clockTime\" : \":00\",\"descriptionShort\" : \"END GAME\",\"down\" : 0,\"isScoringPlay\" : false,\"netYards\" : 0,\"quarter\" : 4,\"yardsToGo\" : 0,\"yardTeamAfter\" : {},\"yardTeamBefore\" : {},\"endPossessionTeam\" : {},\"startPossessionTeam\" : {},\"media\" : {}}],\"same\" : false,\"__cmde__\" : \"currentDrive.js\",\"__processing_ms__\" : \"105\"}";
	
	public void testParse() throws Exception {
		CurrentDriveParser parser = new CurrentDriveParser();
		CurrentDrive drive = parser.parse(new StringReader(json));
		
		assertNotNull(drive);
		
		assertEquals(8, drive.getPlays().size());
		assertEquals("(2:56) 6-T.Morstead punts 53 yards to IND 16, Center-47-J.Drescher.", drive.getPlays().get(0).getDescriptionShort());
	}

}
