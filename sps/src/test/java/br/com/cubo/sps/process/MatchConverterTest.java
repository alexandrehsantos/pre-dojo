package br.com.cubo.sps.process;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.cubo.sps.vo.Match;

public class MatchConverterTest {
	
	private int countKillEvents;
	private String matchId;
	private MatchConverter converter;
	private List<String> eventLineList;
	
	
	
	@Before
	public void init(){
		converter = new MatchConverter();
		matchId = "11348965";
		countKillEvents = 2;
		
		eventLineList = new ArrayList<String>();
		eventLineList.add("23/04/2013 15:34:22 - New match 11348965 has started");
		eventLineList.add("23/04/2013 15:36:04 - Roman killed Nick using M16");
		eventLineList.add("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN");
		eventLineList.add("23/04/2013 15:39:22 - Match 11348965 has ended");
	}
	
	@Test
	public void converter(){
		Match match = converter.convert(eventLineList);
		Assert.assertEquals(matchId, match.getId());
		Assert.assertEquals(countKillEvents, match.getEventKillList().size());
	}

}
