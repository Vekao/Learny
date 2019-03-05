package fr.vekao.learny.model.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Override
	List<Category> findAll();
	
}
