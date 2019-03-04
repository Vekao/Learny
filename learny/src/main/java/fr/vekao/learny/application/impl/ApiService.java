package fr.vekao.learny.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vekao.learny.application.IApiService;
import fr.vekao.learny.model.category.Category;
import fr.vekao.learny.model.category.ICategoryRepository;
import fr.vekao.learny.model.course.Course;
import fr.vekao.learny.model.course.ICourseRepository;

@Service
public class ApiService implements IApiService {
	
	@Autowired
	ICategoryRepository categories;

	@Autowired
	ICourseRepository courses;

	@Override
	public List<Category> allCategories() {
		return categories.findAll();
	}
	
	@Override
	public List<Course> allCourses() {
		return courses.findAll();
	}

}
