package com.delvin.ortiz.candidate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Candidate {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jid;
	
	private String name;
	private String email;
	
	protected Candidate() {
	}
	
	protected Candidate(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Long getJid() {
		return jid;
	}
	public void setJid(Long jid) {
		this.jid = jid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
