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

import fr.vekao.learny.model.Category;
import fr.vekao.learny.repository.ICategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	ICategoryRepository categories;

	
	@CrossOrigin
	@GetMapping("/categories")
	@ResponseBody
	public List<Category> allCategories() {
		return categories.findAll();
	}
	
	/**
	 * GET :/categories:/id
	 * @param id the id of category
	 * @return response entity 200 with the category on Body
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getOneCategory(@PathVariable Long id) {
		Optional<Category> category = categories.findById(id);
		if (!category.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(category);
	}
	
	/**
	 * Post : Create new project
	 *
	 * @param project to create
	 * @return Project created and ResponseEntity with status 201
	 */
	@PostMapping(value = "/categories")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categories.save(category), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one category
	 * 
	 * @param id to the project
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (categories.findById(id) == null) {
			return new ResponseEntity<String>("Cette catégorie n'existe pas", HttpStatus.NOT_FOUND);
		}

		try {
			categories.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}

		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;

	}
	
	@PutMapping(value = "/categories")
	public ResponseEntity<?> updateProject(@RequestBody Category category) {
		Optional<Category> categoryOptional = categories.findById(category.getId());
		if (!categoryOptional.isPresent()) return new ResponseEntity<String>("Catégorie inexistante", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(categories.save(category), HttpStatus.OK);
	}
	
	
	
}
