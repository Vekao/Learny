package fr.vekao.learny.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Favorite {
	
	
	private User user;
	
	private Course course;
}
