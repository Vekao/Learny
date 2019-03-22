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

import fr.vekao.learny.model.Tracking;
import fr.vekao.learny.repository.ITrackingRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/tracking")
public class TrackingController {
	
	@Autowired
	ITrackingRepository trackings;
	
	@GetMapping
	@ResponseBody
	public List<Tracking> allTracking() {
		return trackings.findAll();
	}
	
	/**
	 * GET :/steps:/id
	 * @param id the id of step
	 * @return response entity 200 with the step on Body
	 */
	@GetMapping("/user/{user_id}/course/{course_id}")
	public ResponseEntity<?> getTrackingByCourseAndUser(@PathVariable Long user_id, @PathVariable Long course_id) {
		Optional<Tracking> tracking = trackings.findByCourseAndUser(course_id, user_id);
		if (!tracking.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(tracking);
	}
	
	/**
	 * GET :/tracking:/id
	 * @param id the id of tracking
	 * @return response entity 200 with the step on Body
	 */
	@GetMapping("/user/{st_id}/step/{step_id}")
	public ResponseEntity<?> getTrackingByStepAndUser(@PathVariable Long user_id, @PathVariable Long step_id) {
		Optional<Tracking> tracking = trackings.findByStepAndUser(step_id, user_id);
		if (!tracking.isPresent())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(tracking);
	}
	
	/**
	 * Post : Create new step
	 *
	 * @param step to create
	 * @return Step created and ResponseEntity with status 201
	 */
	@PostMapping
	public ResponseEntity<?> createTracking(@RequestBody Tracking  tracking) {
		if (trackings.findById(tracking.getId()) != null) {
			return new ResponseEntity<String>("Ce suivi existe déjà", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Tracking>(trackings.save(tracking), HttpStatus.CREATED);
	}
	
	/**
	 * Delete : delete one step
	 * 
	 * @param id to the step
	 * @return responseEntity with status 404 if not exist, 200 if it's delete or Exception with status 500
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTracking(@PathVariable Long id) {
		ResponseEntity<?> result = null;

		if (trackings.findById(id) == null) {
			return new ResponseEntity<String>("Ce suivi n'existe pas", HttpStatus.NOT_FOUND);
		}
		try {
			trackings.deleteById(id);
			result = new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception ex) {
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@PutMapping
	public ResponseEntity<?> updateTracking(@RequestBody Tracking tracking) {
		Optional<Tracking> trackingOptional = trackings.findById(tracking.getId());
		if (!trackingOptional.isPresent()) return new ResponseEntity<String>("Suivi inexistante", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(trackings.save(tracking), HttpStatus.OK);
	}
}
