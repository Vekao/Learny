package fr.vekao.learny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.vekao.learny.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	@Override
	List<User> findAll();
}
