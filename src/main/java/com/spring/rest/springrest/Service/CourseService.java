/**
 * 
 */
package com.spring.rest.springrest.Service;

import java.util.List;
import java.util.NoSuchElementException;

import com.spring.rest.springrest.entities.Course;
import com.spring.rest.springrest.exception.ResourceNotAvailableExcpetion;

/**
 * @author omnitya.jha
 *
 */

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourseById(Long id) throws NoSuchElementException;
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Long courseId, Course course);
	
	public void deleteCourse(Long courseId) throws ResourceNotAvailableExcpetion;
	
	public void saveHealthStatus(String metodCalled);
}
