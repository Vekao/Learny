package fr.vekao.learny.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String title;
	
	@ManyToOne
	@NotNull
	private Category category;
	
	@ManyToOne
	@NotNull
	private Type type;
	
	
	@NotNull
	private LocalDateTime publishDate;

	@NotNull
	private String thumbnail;
	
	@NotNull
	private String video;
	
	@OneToMany(mappedBy="course")
	private List<Step> step;
	
	public Course(
			@NotNull String title,
			@NotNull Category category,
			@NotNull Type type,
			@NotNull LocalDateTime publishDate,
			@NotNull String thumbnail,
			@NotNull String video
	) {
		this.title = title;
		this.category = category;
		this.type = type;
		this.publishDate = publishDate;
		this.thumbnail = thumbnail;
		this.video = video;
	}
	
}
