package fr.vekao.learny.model;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String hash;
	
	@NotNull
	private String mail;
	
	@NotNull
	private boolean role;
	
	@NotNull
	private String newMail;


	@NotNull
	private LocalDateTime changeDate;
	
	@NotNull
	private String token;
	
	public User(
			@NotNull String username,
			@NotNull String hash,
			@NotNull String mail,
			@NotNull Boolean role,
			@NotNull String newMail,
			@NotNull LocalDateTime changeDate,
			@NotNull String token
	) {
		this.username = username;
		this.hash = hash;
		this.mail = mail;
		this.role = role;
		this.newMail = newMail;
		this.changeDate = changeDate;
		this.token = token;
	};

}
