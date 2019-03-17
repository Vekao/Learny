package fr.vekao.learny.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Category {
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@NotNull
	private String label;
	
	@OneToMany(mappedBy="category")
	private List<Course> course;
	
	protected Category() {}
	
	public Category(@NotNull String label) {
		this.label = label;
	}


}
