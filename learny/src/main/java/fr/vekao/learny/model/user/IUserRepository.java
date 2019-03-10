package fr.vekao.learny.model.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	@Override
	List<User> findAll();
}
