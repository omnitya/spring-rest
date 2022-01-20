/**
 * 
 */
package com.spring.rest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.springrest.entities.Course;

/**
 * @author omnitya.jha
 *
 */
public interface CourseDao extends JpaRepository<Course, Long>{

}
