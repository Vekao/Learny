package fr.vekao.learny.application;

import java.util.List;

import fr.vekao.learny.model.category.Category;
import fr.vekao.learny.model.course.Course;
import fr.vekao.learny.model.type.Type;
import fr.vekao.learny.model.user.User;

public interface IApiService {
	
	List<Category> allCategories();
	
	List<Course> allCourses();
	
	List<Type> allTypes();
	
	List<User> allUsers();
}
