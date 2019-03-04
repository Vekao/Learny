package fr.vekao.learny.model.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findAll();
	
}
