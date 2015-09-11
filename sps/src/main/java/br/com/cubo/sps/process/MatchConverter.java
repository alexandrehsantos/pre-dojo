package br.com.cubo.sps.process;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cubo.sps.vo.Match;
import br.com.cubo.sps.vo.PlayEventKill;
import br.com.cubo.sps.vo.PlayEventType;

public class MatchConverter {
	
	private static final int INDEX_DATE = 0;
	private static final int INDEX_DESC = 1;
	
	private static final int INDEX_KILLER = 1;
	private static final int INDEX_KILLED = 3;
	private static final int INDEX_WEAPON = 5;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public Match convert(List<String> eventLineList){
		
		Match match = new Match();
		List<PlayEventKill> eventKillList = new ArrayList<PlayEventKill>();
		PlayEventKill eventKill = null;
		
		for (String eventLine : eventLineList) {
			
			if(eventLine.contains(PlayEventType.START_MATCH.getKey())){
				String[] splitLine = eventLine.split("-");
				String date = splitLine[INDEX_DATE];
				try {
					Date startDate =  dateFormat.parse(date);
					match.setStartDate(startDate);
				} catch (ParseException e) {
					throw new RuntimeException("Erro ao converter a data de inicio", e);
				}
				
				String desc = splitLine[INDEX_DESC];
				String id = desc.replace("New match", "").replace("has started", "").trim();
				match.setId(id);
				
			} else if (eventLine.contains(PlayEventType.KILL.getKey())){
				eventKill = new PlayEventKill();
				
				
				String[] splitLine = eventLine.split("-");
				String[] splitEvents = splitLine[INDEX_DESC].split(" ");
				
				eventKill.setKiller(splitEvents[INDEX_KILLER]);
				eventKill.setKilled(splitEvents[INDEX_KILLED]);
				eventKill.setWeapon(splitEvents[INDEX_WEAPON]);
				eventKillList.add(eventKill);
				
			} else if(eventLine.contains(PlayEventType.END_MATCH.getKey())){
				String[] splitLine = eventLine.split("-");
				String date = splitLine[0];
				try {
					Date endDate =  dateFormat.parse(date);
					match.setEndDate(endDate);
				} catch (ParseException e) {
					throw new RuntimeException("Erro ao converter a data de fim", e);
				}
			}
		}
		match.setEventKillList(eventKillList);
		return match;
	}
}
