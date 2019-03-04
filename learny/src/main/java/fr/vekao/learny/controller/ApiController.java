package fr.vekao.learny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vekao.learny.application.IApiService;
import fr.vekao.learny.model.course.Course;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	IApiService apiService;

	@CrossOrigin
	@GetMapping("/courses")
	@ResponseBody
	public List<Course> allCourses() {
		return apiService.allCourses();
	}
	
}
