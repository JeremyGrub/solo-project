package com.jeremy.askwinston.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="dinner")
public class Dinner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String dinnerName;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String dinnerLink;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String dinnerHours;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name = "choice", 
	        joinColumns = @JoinColumn(name = "dinner_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> whoChose;
	
	public List<User> getWhoChose() {
		return whoChose;
	}
	
	public void setWhoChose(List<User> whoChose) {
		this.whoChose = whoChose;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDinnerName() {
		return dinnerName;
	}

	public void setDinnerName(String dinnerName) {
		this.dinnerName = dinnerName;
	}

	public String getDinnerLink() {
		return dinnerLink;
	}

	public void setDinnerLink(String dinnerLink) {
		this.dinnerLink = dinnerLink;
	}

	public String getDinnerHours() {
		return dinnerHours;
	}

	public void setDinnerHours(String dinnerHours) {
		this.dinnerHours = dinnerHours;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
