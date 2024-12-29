/**
 * 
 */
package com.spring.rest.springrest.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.springrest.Service.CourseService;
import com.spring.rest.springrest.entities.Course;
import com.spring.rest.springrest.exception.ResourceNotAvailableExcpetion;

/**
 * @author omnitya.jha
 *
 */

@RestController
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		logger.info("Incoming request for GET all courses");
		return courseService.getCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable String courseId) {
		logger.info("Incoming request for GET course by courseId :: {}", courseId);
		try {
			Course course = courseService.getCourseById(Long.parseLong(courseId));
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/course", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		logger.info("Incoming request for CREATE course with payload :: ", course);
		return courseService.addCourse(course);
	}
	
	@PutMapping(path="/course/{courseId}", consumes = "application/json")
	public Course updateCourse(@PathVariable String courseId, @RequestBody Course course) {
		return courseService.updateCourse(Long.parseLong(courseId), course);
	}
	
	@DeleteMapping(path="/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		logger.info("Incoming request for DELETE course by courseId :: {}", courseId);
		try {
			courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (ResourceNotAvailableExcpetion ex) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/healthcheck")
	public ResponseEntity<HttpStatus> getHealth() {
		logger.info("Incoming request for healthcheck captured!");
		courseService.saveHealthStatus("REST API");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
