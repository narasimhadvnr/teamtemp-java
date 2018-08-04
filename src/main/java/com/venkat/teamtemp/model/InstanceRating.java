package com.venkat.teamtemp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstanceRating {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private int rating;
	
	@Column(nullable = false)
	private String word;
	
	private long timestamp;
	
	private String browserId;
	
	@ManyToOne(targetEntity= TeamInstance.class)
	@JsonIgnore
	private TeamInstance teamInstance;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getBrowserId() {
		return browserId;
	}

	public void setBrowserId(String browserId) {
		this.browserId = browserId;
	}

	public TeamInstance getTeamLink() {
		return teamInstanceId;
	}

	public void setTeamLink(TeamInstance teamLink) {
		this.teamInstanceId = teamLink;
	}
	
	
	
}
