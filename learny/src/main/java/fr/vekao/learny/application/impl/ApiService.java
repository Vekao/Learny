package fr.vekao.learny.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vekao.learny.application.IApiService;
import fr.vekao.learny.model.course.Course;
import fr.vekao.learny.model.course.ICourseRepository;

@Service
public class ApiService implements IApiService {

	@Autowired
	ICourseRepository courses;
	
	@Override
	public List<Course> allCourses() {
		return courses.findAll();
	}

}
