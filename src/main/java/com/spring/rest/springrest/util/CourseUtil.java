/**
 * 
 */
package com.spring.rest.springrest.util;

import java.util.List;
import java.util.UUID;

import com.spring.rest.springrest.entities.Course;

/**
 * @author omnitya.jha
 *
 */
public class CourseUtil {
	
	public static Course fetchCourseById(Long courseId, List<Course> list) {
		Course cs = null;
		for(Course c : list){
			if(c.getCourseId() == courseId) {
				cs = c;
				break;
			}
		}
		return cs;
	}
	
	public static Long generateId() {
		String uniqueID = UUID.randomUUID().toString();
		return Long.getLong(uniqueID);
	}

}
