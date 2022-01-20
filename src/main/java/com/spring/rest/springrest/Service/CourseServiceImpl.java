/**
 * 
 */
package com.spring.rest.springrest.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.springrest.dao.CourseDao;
import com.spring.rest.springrest.entities.Course;
import com.spring.rest.springrest.exception.ResourceNotAvailableExcpetion;

/**
 * @author omnitya.jha
 *
 */

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao dao;

	@Override
	public List<Course> getCourses() {
		return dao.findAll();
	}

	@Override
	public Course getCourseById(Long id) throws NoSuchElementException {
		Optional<Course> course = dao.findById(id);
		return course.get();
	}

	@Override
	public Course addCourse(Course course) {
		Course cos = new Course();
		cos.setCourseDesc(course.getCourseDesc());
		cos.setCourseName(course.getCourseName());
		cos.setCourseTitle(course.getCourseTitle());
		return dao.save(cos);
	}

	@Override
	public Course updateCourse(Long courseId, Course course) {
		
		Optional<Course> cs = dao.findById(courseId);
		if(cs.get() != null) {
			cs.get().setCourseId(courseId);
			cs.get().setActive("Y");
			cs.get().setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		} 
		
		return dao.save(cs.get());
	}

	@Override
	public void deleteCourse(Long courseId) throws ResourceNotAvailableExcpetion {
		Course course = dao.getById(courseId);
		dao.delete(course);
	}

}
