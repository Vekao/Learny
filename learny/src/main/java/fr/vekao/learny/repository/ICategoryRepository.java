package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.vekao.learny.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Override
	List<Category> findAll();
	
	public Category findByLabel(String label);
	
}