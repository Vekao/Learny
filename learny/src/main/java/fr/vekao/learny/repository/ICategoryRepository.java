package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Override
	List<Category> findAll();
	
	Category findByLabel(String label);
	
}