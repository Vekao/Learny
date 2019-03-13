package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	@Override
	List<Course> findAll();
	
	public List<Course> findByCategoryAndType(Long category, Long type);
}
