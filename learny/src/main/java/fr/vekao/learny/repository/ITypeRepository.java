package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.Type;

public interface ITypeRepository extends JpaRepository<Type, Long> {
	
	@Override
	List<Type> findAll();
	
}
