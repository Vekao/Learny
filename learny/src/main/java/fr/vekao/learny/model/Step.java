package fr.vekao.learny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Step {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String title;
	
	@NotNull
	private int num;
	
	@NotNull
	@ManyToOne
	private Course course;
	
	@NotNull
	private String timestamp;
	
	
	private String photo;
	
	private String schematic;

	
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
