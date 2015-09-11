package br.com.cubo.sps.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cubo.sps.vo.Match;
import br.com.cubo.sps.vo.PlayEventKill;
import br.com.cubo.sps.vo.Score;

public class MatchScorer {

	public List<Score> createScore(List<Match> matchList) {

		List<Score> scoreList = new ArrayList<Score>();

		for (Match match : matchList) {
			Score score = new Score();
			score.setMachId(match.getId());
			score.setKillerScore(createKillerScore(match));
			score.setKilledScore(createKilledScore(match));
			scoreList.add(score);
		}

		return scoreList;
	}

	private Map<String, Integer> createKilledScore(Match match) {

		Map<String, Integer> killedMap = new HashMap<String, Integer>();

		List<PlayEventKill> eventKillList = match.getEventKillList();

		for (PlayEventKill playEventKill : eventKillList) {

			String killed = playEventKill.getKilled();

			if (killedMap.containsKey(killed)) {

				Integer count = killedMap.get(killed);

				killedMap.put(killed, count += 1);

			} else {
				killedMap.put(killed, 1);
			}

		}

		return killedMap;
	}

	private Map<String, Integer> createKillerScore(Match match) {
		Map<String, Integer> killerMap = new HashMap<String, Integer>();

		List<PlayEventKill> eventKillList = match.getEventKillList();

		for (PlayEventKill playEventKill : eventKillList) {

			String killer = playEventKill.getKiller().trim();

			if (!killer.equals("<WORLD>")) {
				if (killerMap.containsKey(killer)) {

					Integer count = killerMap.get(killer);

					killerMap.put(killer, count += 1);

				} else {
					killerMap.put(killer, 1);
				}
			}
		}

		return killerMap;
	}

}
