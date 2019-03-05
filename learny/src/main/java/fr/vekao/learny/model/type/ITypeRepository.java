package fr.vekao.learny.model.type;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<Type, Long> {
	
	@Override
	List<Type> findAll();
	
}
