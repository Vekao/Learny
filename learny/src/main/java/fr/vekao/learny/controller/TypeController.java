package fr.vekao.learny.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vekao.learny.model.Type;
import fr.vekao.learny.repository.ITypeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TypeController {

	@Autowired
	ITypeRepository types;

	@GetMapping("/types")
	@ResponseBody
	public List<Type> allTypes() {
		return types.findAll();
	}
	
	/**
	 * GET :/categories:/id
	 * @param id the id of category
	 * @return response entity 200 with the category on Body
	 */
	@GetMapping("/types/{id}")
	public ResponseEntity<?> getOneType(@PathVariable Long id) {
		Optional<Type> type = types.findById(id);
		if (!type.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(type);
	}
	
	/**
	 * Post : Create new project
	 *
	 * @param project to create
	 * @return Project created and ResponseEntity with status 201
	 */
	@PostMapping("/types")
	public ResponseEntity<?> createType(@RequestBody Type type) {
		return new ResponseEntity<Type>(types.save(type), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one category
	 * 
	 * @param id to the project
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/types/{id}")
	public ResponseEntity<?> deleteType(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (types.findById(id) == null) {
			return new ResponseEntity<String>("Ce type n'existe pas", HttpStatus.NOT_FOUND);
		}

		try {
			types.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}

		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;

	}
	
	@PutMapping(value = "/types")
	public ResponseEntity<?> updateType(@RequestBody Type type) {
		Optional<Type> typeOptional = types.findById(type.getId());
		if (!typeOptional.isPresent()) return new ResponseEntity<String>("Type inexistant", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(types.save(type), HttpStatus.OK);
	}
	
}
