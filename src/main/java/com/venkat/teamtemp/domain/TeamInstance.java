package com.venkat.teamtemp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
	
@Entity
public class TeamInstance {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)

	private long Id;
	
	@NotNull
	private String instanceName;

	@OneToMany
	private List<InstanceRating> ratings;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public List<InstanceRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<InstanceRating> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
