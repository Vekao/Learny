package fr.vekao.learny.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vekao.learny.application.IApiService;
import fr.vekao.learny.model.category.Category;
import fr.vekao.learny.model.category.ICategoryRepository;
import fr.vekao.learny.model.course.Course;
import fr.vekao.learny.model.course.ICourseRepository;
import fr.vekao.learny.model.type.ITypeRepository;
import fr.vekao.learny.model.type.Type;
import fr.vekao.learny.model.user.IUserRepository;
import fr.vekao.learny.model.user.User;

@Service
public class ApiService implements IApiService {
	
	@Autowired
	ICategoryRepository categories;

	@Autowired
	ICourseRepository courses;
	
	@Autowired
	ITypeRepository types;
	
	@Autowired
	IUserRepository users;

	@Override
	public List<Category> allCategories() {
		return categories.findAll();
	}
	
	@Override
	public List<Course> allCourses() {
		return courses.findAll();
	}
	
	@Override
	public List<Type> allTypes() {
		return types.findAll();
	}
	
	@Override
	public List<User> allUsers() {
		return users.findAll();
	}

}
