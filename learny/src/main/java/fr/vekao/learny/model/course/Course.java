package fr.vekao.learny.model.course;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import fr.vekao.learny.model.category.Category;
import fr.vekao.learny.model.type.Type;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@NotNull
	private String title;
	
	@Getter
	@Setter
	@ManyToOne
	@NotNull
	private Category category;
	
	@Getter
	@Setter
	@ManyToOne
	@NotNull
	private Type type;
	
	@Getter
	@Setter
	@NotNull
	private long views;
	
	@Getter
	@Setter
	@NotNull
	private LocalDateTime publishDate;

	@Getter
	@Setter
	@NotNull
	private String thumbnail;
	
	protected Course() {}
	
	public Course(
			@NotNull String title,
			@NotNull Category category,
			@NotNull Type type,
			@NotNull long views,
			@NotNull LocalDateTime publishDate,
			@NotNull String thumbnail
	) {
		this.title = title;
		this.thumbnail = thumbnail;
	}
	
}
