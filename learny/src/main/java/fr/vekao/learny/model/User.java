package fr.vekao.learny.model;

//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@NotNull
	private String username;
	
	@Getter
	@Setter
	@NotNull
	private String hash;
	
	@Getter
	@Setter
	@NotNull
	private String mail;
	
	@Getter
	@Setter
	@NotNull
	private int role;
	
	@Getter
	@Setter
	@NotNull
	private String newMail;
	
//	@Getter
//	@Setter
//	@NotNull
//	private LocalDateTime changeDate;
	
	@Getter
	@Setter
	@NotNull
	private String token;
	
	protected User() {}
	
	public User(
			@NotNull String username,
			@NotNull String hash,
			@NotNull String mail,
			@NotNull int role,
			@NotNull String newMail,
//			@NotNull LocalDateTime changeDate,
			@NotNull String token
	) {
		this.username = username;
		this.hash = hash;
		this.mail = mail;
		this.role = role;
		this.newMail = newMail;
//		this.changeDate = changeDate;
		this.token = token;
	};

}
