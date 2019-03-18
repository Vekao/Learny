package fr.vekao.learny.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	@GetMapping
	@ResponseBody
	public List<User> allUsers() {
		return users.findAll();
	}
	
	/**
	 * GET :/users:/id
	 * @param id the id of user
	 * @return response entity 200 with the course on Body
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable Long id) {
		Optional<User> user = users.findById(id);
		if (!user.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(user);
	}
	
	/**
	 * Post : Create new User
	 *
	 * @param user to create
	 * @return user created and ResponseEntity with status 201
	 */
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(users.save(user), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one course
	 * 
	 * @param id to the course
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (users.findById(id) == null) {
			return new ResponseEntity<String>("Cette utilisateur n'existe pas", HttpStatus.NOT_FOUND);
		}
		try {
			users.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		Optional<User> userOptional = users.findById(user.getId());
		if (!userOptional.isPresent()) return new ResponseEntity<String>("Utilisateur inexistant", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(users.save(user), HttpStatus.OK);
	}
	
}
