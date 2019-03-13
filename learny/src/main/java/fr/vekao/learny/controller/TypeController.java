package fr.vekao.learny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vekao.learny.model.Type;
import fr.vekao.learny.repository.ITypeRepository;

@RestController
@RequestMapping("/api")
public class TypeController {

	@Autowired
	ITypeRepository types;

	
	
	@CrossOrigin
	@GetMapping("/types")
	@ResponseBody
	public List<Type> allTypes() {
		return types.findAll();
	}
	
}
