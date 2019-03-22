package fr.vekao.learny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Tracking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@OneToOne
	private User user;
	
	@NotNull
	@OneToOne
	private Course course;
	
	@NotNull
	@OneToOne
	private Step step;
	
	/* Timestamp for course last position by user */
	private String timestamp; 
	
	/* status of the user's course, O= not started / 1= started / 2= finished */
	@NotNull
	private int status;
	
	public Tracking(
			@NotNull User user,
			@NotNull Course course,
			@NotNull Step step,
			String timestamp,
			@NotNull int status
			) {
		this.user = user;
		this.course = course;
		this.step = step;
		this.timestamp = timestamp;
		this.status = status;
	}
}
