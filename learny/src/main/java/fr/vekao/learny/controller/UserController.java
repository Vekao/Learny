package fr.vekao.learny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vekao.learny.model.User;
import fr.vekao.learny.repository.IUserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	IUserRepository users;

	
	@CrossOrigin
	@GetMapping
	@ResponseBody
	public List<User> allUsers() {
		return users.findAll();
	}
	
}
