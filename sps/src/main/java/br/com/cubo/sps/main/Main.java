package br.com.cubo.sps.main;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.cubo.sps.process.MatchScorer;
import br.com.cubo.sps.process.PLayFileReader;
import br.com.cubo.sps.vo.Match;
import br.com.cubo.sps.vo.Score;

public class Main {
	public static void main(String[] args) {

		InputStream fileLog = Main.class.getClassLoader().getResourceAsStream(
				"play-log.log");

		PLayFileReader pLayFileReader = new PLayFileReader();

		List<Match> matchList = pLayFileReader.read(fileLog);

		MatchScorer matchScorer = new MatchScorer();

		List<Score> createScore = matchScorer.createScore(matchList);

		for (Score score : createScore) {

			System.out.println(score.getMachId());

			Map<String, Integer> killerScore = score.getKillerScore();
			
			Set<Entry<String, Integer>> killerEntrySet = killerScore.entrySet();
			
			for (Entry<String, Integer> entry : killerEntrySet) {
				
				System.out.println("Kills " + entry.getKey() + " - " + entry.getValue());
				
			}

			Map<String, Integer> killedScore = score.getKilledScore();

			Set<Entry<String, Integer>> killedEntrySet = killedScore.entrySet();

			for (Entry<String, Integer> entry : killedEntrySet) {

				System.out.println("Deads " + entry.getKey() + " - " + entry.getValue());

			}

		}

	}
}
