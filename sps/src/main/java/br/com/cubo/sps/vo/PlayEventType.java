package br.com.cubo.sps.vo;

public enum PlayEventType {

	START_MATCH("has started"), END_MATCH("has ended"), KILL("killed");

	private String key;

	private PlayEventType(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
