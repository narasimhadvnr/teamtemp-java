package com.venkat.teamtemp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	private String roleType;
	
	@ManyToOne
	@JoinColumn(name = "creator",referencedColumnName="id")
	@JsonIgnore
	private User creatorUser;
	
	@OneToMany(mappedBy="team")	
	private List<Theme> links;

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

	public List<Theme> getLinks() {
		return links;
	}

	public void setLinks(List<Theme> links) {
		this.links = links;
	}
	
	public boolean addTeamLink(Theme instance) {
		
		if(this.links ==null || this.links.size() ==0) {
			return false;
		}
		
		this.links.add(instance);
		return true;
	}
}
