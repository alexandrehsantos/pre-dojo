package br.com.cubo.sps.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.cubo.sps.vo.Match;
import br.com.cubo.sps.vo.PlayEventType;

public class PLayFileReader {

	public List<Match> read(InputStream stream) {

		MatchConverter converter = new MatchConverter();
		List<Match> matchList = new ArrayList<Match>();
		List<String> eventLineList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
				eventLineList.add(line);
				if (line.contains(PlayEventType.END_MATCH.getKey())) {
					eventLineList.add(line);
					Match match = converter.convert(eventLineList);
					matchList.add(match);
					eventLineList = new ArrayList<String>();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Erro ao tentar ler o arquivo", e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException("Erro ao fechar stream", e);
			}
		}
		return matchList;
	}
}
