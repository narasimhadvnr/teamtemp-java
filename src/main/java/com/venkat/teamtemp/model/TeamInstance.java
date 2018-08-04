package com.venkat.teamtemp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
	
@Entity
public class TeamInstance {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="link_id")
	private RatingLink linkValue;

	@ManyToOne
	@JsonIgnore
	private Team team;
	
	@OneToMany(mappedBy="teamInstance")
	public List<InstanceRating> ratings;
	
	public TeamInstance() {
		
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamInstance(RatingLink linkValue) {
		this.linkValue = linkValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RatingLink getLinkValue() {
		return linkValue;
	}

	public void setLinkValue(RatingLink linkValue) {
		this.linkValue = linkValue;
	}

	public List<InstanceRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<InstanceRating> ratings) {
		this.ratings = ratings;
	}	
	
}
