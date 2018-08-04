package com.venkat.teamtemp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Id;


@Entity
public class RatingLink {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)

	private long id;
	
	private long validFrom;
	
	private long validTill;
	
	private String status;
	
	private String link;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(long validFrom) {
		this.validFrom = validFrom;
	}

	public long getValidTill() {
		return validTill;
	}

	public void setValidTill(long validTill) {
		this.validTill = validTill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
