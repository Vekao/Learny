package fr.vekao.learny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vekao.learny.model.Course;
import fr.vekao.learny.repository.ICourseRepository;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	ICourseRepository courses;

	
	
	@CrossOrigin
	@GetMapping("/courses")
	@ResponseBody
	public List<Course> allCourses() {
		return courses.findAll();
	}
	
}
