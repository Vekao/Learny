package fr.vekao.learny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Step {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/* title of this step */
	@NotNull
	private String title;
	
	/* step number */
	@NotNull
	private int num;
	
	/* course this step is from */
	@NotNull
	@ManyToOne
	private Course course;
	
	/* Timestamp for video chapter */
	@NotNull
	private String timestamp;
	
	/* photo of this step */
	private String photo;
	
	/* schematic of this step */
	private String schematic;
	
	@OneToOne
	private Tracking tracking;
	
	public Step (
			@NotNull String title, 
			@NotNull int num, 
			@NotNull Course course,
			@NotNull String timestamp,
			String photo,
			String schematic
	){
		this.title = title;
		this.num = num;
		this.course = course;
		this.timestamp = timestamp;
		this.photo = photo;
		this.schematic = schematic;
	}
}
