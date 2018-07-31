package com.venkat.teamtemp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Team {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	
	private String name;
	
	private String roleType;
	
	@ManyToOne
	@JoinColumn(name = "creator")
	private User creatorUser;
	
	@OneToMany
	@JoinColumn(name="link")
	private List<TeamInstance> links;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public User getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
	}

	public List<TeamInstance> getLinks() {
		return links;
	}

	public void setLinks(List<TeamInstance> links) {
		this.links = links;
	}
	
	public boolean addTeamLink(TeamInstance instance) {
		
		if(this.links ==null || this.links.size() ==0) {
			return false;
		}
		
		this.links.add(instance);
		return true;
	}
}