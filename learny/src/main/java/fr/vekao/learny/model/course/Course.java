package fr.vekao.learny.model.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@NotNull
	private String title;
	
	@Getter
	@NotNull
	private String thumbnail;
	
	protected Course() {
	};
	
	public Course(@NotNull String title, @NotNull String thumbnail) {
		this.title = title;
		this.thumbnail = thumbnail;
	}
	
}
