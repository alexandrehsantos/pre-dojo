package br.com.cubo.sps.vo;

import java.util.Date;
import java.util.List;

public class Match {

	private String id;
	private Date startDate;
	private Date endDate;
	private List<PlayEventKill> eventKillList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<PlayEventKill> getEventKillList() {
		return eventKillList;
	}

	public void setEventKillList(List<PlayEventKill> eventKillList) {
		this.eventKillList = eventKillList;
	}
}