package com.vikinghammer.nfl.scoreboard.parse;

import java.io.StringReader;

import junit.framework.TestCase;

import com.vikinghammer.nfl.scoreboard.model.stat.GameStats;

public class GameStatsPastTest extends TestCase {
	
	private String json = "{\"gameId\":\"2011102311\",\"state\":\"not_pre\",\"home\":{\"teamId\":\"3300\",\"labels\":[\"Total First Downs\",\"First Down By Rush\",\"First Down By Pass\",\"First Down By Penalty\",\"Third Down Conversions\",\"Fourth Down Conversions\",\"Total Offensive Yards\",\"Offensive Plays\",\"Offensive Average Yards\",\"Total Rushing Yards\",\"Rush Plays\",\"Rush Average Yards\",\"Total Passing Yards\",\"Pass Completions\",\"Pass Attempts\",\"Pass Interceptions\",\"Pass Average Yards\",\"Sacks\",\"Field Goals\",\"Touchdowns\",\"Touchdown By Rush\",\"Touchdown By Pass\",\"Touchdown By Return\",\"Touchdown By Defense\",\"Time Of Possesion\"],\"stats\":[\"36\",\"16\",\"19\",\"0\",\"6/8\",\"0/0\",\"557.0\",\"75\",\"7.4\",\"236.0\",\"38\",\"6.2\",\"321.0\",\"31\",\"35\",\"0\",\"8.7\",\"2\",\"2/2\",\"8\",\"2\",\"5\",\"0\",\"1\",\"38:19\"],\"passing\":{\"labels\":[\"Cmp\",\"Att\",\"Yds\",\"TDs\"],\"players\":[{\"playerId\":\"BRE229498\",\"firstName\":\"Drew\",\"lastName\":\"Brees\",\"stats\":[\"31\",\"35\",\"325\",\"5\"]}]},\"rushing\":{\"labels\":[\"Car\",\"Yds\",\"Avg\",\"TDs\"],\"players\":[{\"playerId\":\"ING656964\",\"firstName\":\"Mark\",\"lastName\":\"Ingram\",\"stats\":[\"14\",\"91\",\"6.5\",\"0\"]},{\"playerId\":\"SPR711296\",\"firstName\":\"Darren\",\"lastName\":\"Sproles\",\"stats\":[\"12\",\"88\",\"7.3\",\"1\"]},{\"playerId\":\"THO085535\",\"firstName\":\"Pierre\",\"lastName\":\"Thomas\",\"stats\":[\"10\",\"57\",\"5.7\",\"0\"]},{\"playerId\":\"COL612676\",\"firstName\":\"Jed\",\"lastName\":\"Collins\",\"stats\":[\"1\",\"1\",\"1\",\"1\"]},{\"playerId\":\"MEA057501\",\"firstName\":\"Robert\",\"lastName\":\"Meachem\",\"stats\":[\"1\",\"-1\",\"-1\",\"0\"]}]},\"receiving\":{\"labels\":[\"Rec\",\"Yds\",\"Avg\",\"TDs\"],\"players\":[{\"playerId\":\"COL777594\",\"firstName\":\"Marques\",\"lastName\":\"Colston\",\"stats\":[\"7\",\"98\",\"14\",\"2\"]},{\"playerId\":\"THO085535\",\"firstName\":\"Pierre\",\"lastName\":\"Thomas\",\"stats\":[\"5\",\"68\",\"13.6\",\"0\"]},{\"playerId\":\"GRA207087\",\"firstName\":\"Jimmy\",\"lastName\":\"Graham\",\"stats\":[\"6\",\"54\",\"9\",\"2\"]},{\"playerId\":\"MOO468248\",\"firstName\":\"Lance\",\"lastName\":\"Moore\",\"stats\":[\"3\",\"44\",\"14.7\",\"0\"]},{\"playerId\":\"MEA057501\",\"firstName\":\"Robert\",\"lastName\":\"Meachem\",\"stats\":[\"2\",\"27\",\"13.5\",\"0\"]},{\"playerId\":\"SPR711296\",\"firstName\":\"Darren\",\"lastName\":\"Sproles\",\"stats\":[\"6\",\"19\",\"3.2\",\"1\"]},{\"playerId\":\"HEN056415\",\"firstName\":\"Devery\",\"lastName\":\"Henderson\",\"stats\":[\"1\",\"9\",\"9\",\"0\"]},{\"playerId\":\"ING656964\",\"firstName\":\"Mark\",\"lastName\":\"Ingram\",\"stats\":[\"1\",\"6\",\"6\",\"0\"]}]}},\"away\":{\"teamId\":\"2200\",\"labels\":[\"Total First Downs\",\"First Down By Rush\",\"First Down By Pass\",\"First Down By Penalty\",\"Third Down Conversions\",\"Fourth Down Conversions\",\"Total Offensive Yards\",\"Offensive Plays\",\"Offensive Average Yards\",\"Total Rushing Yards\",\"Rush Plays\",\"Rush Average Yards\",\"Total Passing Yards\",\"Pass Completions\",\"Pass Attempts\",\"Pass Interceptions\",\"Pass Average Yards\",\"Sacks\",\"Field Goals\",\"Touchdowns\",\"Touchdown By Rush\",\"Touchdown By Pass\",\"Touchdown By Return\",\"Touchdown By Defense\",\"Time Of Possesion\"],\"stats\":[\"11\",\"6\",\"5\",\"0\",\"4/11\",\"0/0\",\"252.0\",\"46\",\"5.5\",\"155.0\",\"23\",\"6.7\",\"97.0\",\"12\",\"22\",\"1\",\"4.2\",\"1\",\"0/0\",\"1\",\"1\",\"0\",\"0\",\"0\",\"21:41\"],\"passing\":{\"labels\":[\"Cmp\",\"Att\",\"Yds\",\"TDs\"],\"players\":[{\"playerId\":\"PAI701900\",\"firstName\":\"Curtis\",\"lastName\":\"Painter\",\"stats\":[\"9\",\"17\",\"67\",\"0\"]},{\"playerId\":\"ORL645634\",\"firstName\":\"Dan\",\"lastName\":\"Orlovsky\",\"stats\":[\"3\",\"5\",\"35\",\"0\"]}]},\"rushing\":{\"labels\":[\"Car\",\"Yds\",\"Avg\",\"TDs\"],\"players\":[{\"playerId\":\"CAR642622\",\"firstName\":\"Delone\",\"lastName\":\"Carter\",\"stats\":[\"10\",\"89\",\"8.9\",\"1\"]},{\"playerId\":\"BRO398445\",\"firstName\":\"Donald\",\"lastName\":\"Brown\",\"stats\":[\"9\",\"47\",\"5.2\",\"0\"]},{\"playerId\":\"PAI701900\",\"firstName\":\"Curtis\",\"lastName\":\"Painter\",\"stats\":[\"2\",\"11\",\"5.5\",\"0\"]},{\"playerId\":\"ADD152616\",\"firstName\":\"Joseph\",\"lastName\":\"Addai\",\"stats\":[\"2\",\"8\",\"4\",\"0\"]}]},\"receiving\":{\"labels\":[\"Rec\",\"Yds\",\"Avg\",\"TDs\"],\"players\":[{\"playerId\":\"WAY456953\",\"firstName\":\"Reggie\",\"lastName\":\"Wayne\",\"stats\":[\"3\",\"36\",\"12\",\"0\"]},{\"playerId\":\"GAR115573\",\"firstName\":\"Pierre\",\"lastName\":\"Garcon\",\"stats\":[\"3\",\"31\",\"10.3\",\"0\"]},{\"playerId\":\"COL397342\",\"firstName\":\"Austin\",\"lastName\":\"Collie\",\"stats\":[\"2\",\"12\",\"6\",\"0\"]},{\"playerId\":\"ELD553860\",\"firstName\":\"Brody\",\"lastName\":\"Eldridge\",\"stats\":[\"2\",\"12\",\"6\",\"0\"]},{\"playerId\":\"ADD152616\",\"firstName\":\"Joseph\",\"lastName\":\"Addai\",\"stats\":[\"2\",\"11\",\"5.5\",\"0\"]}]}},\"same\":false,\"__cmde__\":\"gameStats.js\",\"__processing_ms__\":\"302\"}";
	
	public void testParse() throws Exception {
		GameStatsParser parser = new GameStatsParser();
		GameStats stats = parser.parse(new StringReader(json));
		
		assertNotNull(stats);
		assertEquals("2011102311", stats.getGameId());
		assertEquals("not_pre", stats.getState());
		
		assertNotNull(stats.getHome());
		assertEquals("3300", stats.getHome().getTeamId());
		assertEquals(25, stats.getHome().getStats().size());
		assertEquals("Total First Downs", stats.getHome().getStats().get(0).getLabel());
		assertEquals("36", stats.getHome().getStats().get(0).getValue());
		
		assertNotNull(stats.getHome().getPassing());
		assertEquals(4, stats.getHome().getPassing().getLabels().size());
		assertEquals("Cmp", stats.getHome().getPassing().getLabels().get(0));
		assertEquals("Drew Brees", stats.getHome().getPassing().getPlayers().get(0).getName());
		assertEquals("31", stats.getHome().getPassing().getPlayers().get(0).getStats().get(0));
		assertEquals("35", stats.getHome().getPassing().getPlayers().get(0).getStats().get(1));
		assertEquals("325", stats.getHome().getPassing().getPlayers().get(0).getStats().get(2));
		assertEquals("5", stats.getHome().getPassing().getPlayers().get(0).getStats().get(3));
		
		assertNotNull(stats.getHome().getRushing());
		assertEquals(4, stats.getHome().getRushing().getLabels().size());
		assertEquals("Car", stats.getHome().getRushing().getLabels().get(0));
		assertEquals("Mark Ingram", stats.getHome().getRushing().getPlayers().get(0).getName());
		assertEquals("Darren Sproles", stats.getHome().getRushing().getPlayers().get(1).getName());
		
		assertNotNull(stats.getHome().getReceiving());
		assertEquals(4, stats.getHome().getReceiving().getLabels().size());
		assertEquals("Rec", stats.getHome().getReceiving().getLabels().get(0));
		assertEquals("Marques Colston", stats.getHome().getReceiving().getPlayers().get(0).getName());
		assertEquals("Pierre Thomas", stats.getHome().getReceiving().getPlayers().get(1).getName());
		
		assertNotNull(stats.getAway());
		assertEquals("2200", stats.getAway().getTeamId());
		assertEquals(25, stats.getAway().getStats().size());
		assertEquals("Total First Downs", stats.getAway().getStats().get(0).getLabel());
		assertEquals("11", stats.getAway().getStats().get(0).getValue());
		
		assertNotNull(stats.getAway().getPassing());
		assertEquals("Curtis Painter", stats.getAway().getPassing().getPlayers().get(0).getName());
		
		assertNotNull(stats.getAway().getRushing());
		assertEquals("Delone Carter", stats.getAway().getRushing().getPlayers().get(0).getName());
		
		assertNotNull(stats.getAway().getReceiving());
		assertEquals("Reggie Wayne", stats.getAway().getReceiving().getPlayers().get(0).getName());
	}

}
