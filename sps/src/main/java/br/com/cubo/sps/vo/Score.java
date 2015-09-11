package br.com.cubo.sps.vo;

import java.util.HashMap;
import java.util.Map;

public class Score {

	private String machId;
	private Map<String, Integer> killerScore = new HashMap<String, Integer>();
	private Map<String, Integer> killedScore = new HashMap<String, Integer>();

	public String getMachId() {
		return machId;
	}

	public void setMachId(String machId) {
		this.machId = machId;
	}

	public Map<String, Integer> getKillerScore() {
		return killerScore;
	}

	public void setKillerScore(Map<String, Integer> killerScore) {
		this.killerScore = killerScore;
	}

	public Map<String, Integer> getKilledScore() {
		return killedScore;
	}

	public void setKilledScore(Map<String, Integer> killedScore) {
		this.killedScore = killedScore;
	}

}
