package fr.vekao.learny.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.Tracking;

public interface ITrackingRepository extends JpaRepository<Tracking, Long>{

	Optional<Tracking> findByStepAndUser(Long step, Long user);
	
	Optional<Tracking> findByCourseAndUser(Long course, Long user);
}
