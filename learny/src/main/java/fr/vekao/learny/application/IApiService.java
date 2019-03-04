package fr.vekao.learny.application;

import java.util.List;

import fr.vekao.learny.model.course.Course;

public interface IApiService {
	
	List<Course> allCourses();
}
