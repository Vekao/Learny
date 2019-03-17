package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.Step;

public interface IStepRepository extends JpaRepository<Step, Long> {
	
	@Override
	List<Step> findAll();
	
	List<Step> findByNum(int num);
}
