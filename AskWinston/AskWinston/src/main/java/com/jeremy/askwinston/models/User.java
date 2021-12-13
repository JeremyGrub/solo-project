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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Size(min=2, max=100, message="Name should be between 2-50")
	private String name;
	
	@Email
	private String email;
	
	@NotBlank
	@Size(min=8, max=100, message="Password should be between 8-100")
	private String password;
	
	@NotBlank
	@Transient
	private String passwordConfirmation;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Dinner> dinners;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	name = "choice", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "dinner_id")
    )
    private List<Dinner> dinnerChose;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Dinner> getDinners() {
		return dinners;
	}

	public void setDinners(List<Dinner> dinners) {
		this.dinners = dinners;
	}

	public List<Dinner> getDinnerChose() {
		return dinnerChose;
	}

	public void setDinnerChose(List<Dinner> dinnerChose) {
		this.dinnerChose = dinnerChose;
	}
	
	
}
