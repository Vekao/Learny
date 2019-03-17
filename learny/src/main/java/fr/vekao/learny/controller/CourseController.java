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

import fr.vekao.learny.model.Course;
import fr.vekao.learny.repository.ICourseRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	ICourseRepository courses;

	
	
	
	@GetMapping("/courses")
	@ResponseBody
	public List<Course> allCourses() {
		return courses.findAll();
	}
	
	/**
	 * GET :/courses:/id
	 * @param id the id of course
	 * @return response entity 200 with the course on Body
	 */
	@GetMapping("/courses/{id}")
	public ResponseEntity<?> getOneCourse(@PathVariable Long id) {
		Optional<Course> course = courses.findById(id);
		if (!course.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(course);
	}
	
	/**
	 * Post : Create new course
	 *
	 * @param course to create
	 * @return course created and ResponseEntity with status 201
	 */
	@PostMapping(value = "/courses")
	public ResponseEntity<?> createCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(courses.save(course), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one course
	 * 
	 * @param id to the course
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (courses.findById(id) == null) {
			return new ResponseEntity<String>("Ce cours n'existe pas", HttpStatus.NOT_FOUND);
		}
		try {
			courses.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@PutMapping(value = "/courses")
	public ResponseEntity<?> updateProject(@RequestBody Course course) {
		Optional<Course> categoryOptional = courses.findById(course.getId());
		if (!categoryOptional.isPresent()) return new ResponseEntity<String>("Cours inexistant", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(courses.save(course), HttpStatus.OK);
	}
	
	
	
	
}
