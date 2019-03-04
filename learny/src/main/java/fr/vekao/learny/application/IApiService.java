package fr.vekao.learny.application;

import java.util.List;

import fr.vekao.learny.model.category.Category;
import fr.vekao.learny.model.course.Course;

public interface IApiService {
	
	List<Category> allCategories();
	
	List<Course> allCourses();
	
}
