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
public class Type {
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@NotNull
	private String label;
	
	@OneToMany(mappedBy="type")
	private List<Course> courses;
	
	protected Type() {}
	
	public Type(@NotNull String label) {
		this.label = label;
	}
	
}
