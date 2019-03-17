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

import fr.vekao.learny.model.Step;
import fr.vekao.learny.repository.IStepRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/steps")
public class StepController {
	
	@Autowired
	IStepRepository steps;
	
	@GetMapping
	@ResponseBody
	public List<Step> allSteps() {
		return steps.findAll();
	}
	
	/**
	 * GET :/steps:/id
	 * @param id the id of step
	 * @return response entity 200 with the step on Body
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneStep(@PathVariable Long id) {
		Optional<Step> step = steps.findById(id);
		if (!step.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(step);
	}
	
	/**
	 * Post : Create new step
	 *
	 * @param step to create
	 * @return Step created and ResponseEntity with status 201
	 */
	@PostMapping
	public ResponseEntity<?> createStep(@RequestBody Step step) {
		if (steps.findByNum(step.getNum()) != null) {
			return new ResponseEntity<String>("Cette étape existe déjà", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Step>(steps.save(step), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one step
	 * 
	 * @param id to the step
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStep(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (steps.findById(id) == null) {
			return new ResponseEntity<String>("Cette étape n'existe pas", HttpStatus.NOT_FOUND);
		}
		try {
			steps.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@PutMapping
	public ResponseEntity<?> updateStep(@RequestBody Step step) {
		Optional<Step> stepOptional = steps.findById(step.getId());
		if (!stepOptional.isPresent()) return new ResponseEntity<String>("Etape inexistante", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(steps.save(step), HttpStatus.OK);
	}
}
