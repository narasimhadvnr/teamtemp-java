package com.venkat.teamtemp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class ThemeRating {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int rating;
	
	@Column(nullable = false)
	private String comment;
	
	private long timestamp;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String browserId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String commentBy;
	
	@ManyToOne
	@JsonIgnore
	private Theme theme;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String location;
	
	public ThemeRating() {
		
	}
	
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme teamLink) {
		this.theme = teamLink;
	}

	public String getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	
	
	
}
