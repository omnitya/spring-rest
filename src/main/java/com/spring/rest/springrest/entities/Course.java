/**
 * 
 */
package com.spring.rest.springrest.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * @author omnitya.jha
 *
 */

@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long courseId;
	private String courseName;
	private String courseTitle;
	private String courseDesc;
	private String createdOn;
	private String updatedOn;
	private String active;
	
	public Course() {
		//this.setCourseId(CourseUtil.generateId());
		this.setCreatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.active = "Y";
	}
	
	public Course(long courseId, String courseName, String courseTitle, String courseDesc) {
		//this.courseId = CourseUtil.generateId();
		this.courseName = courseName;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.setCreatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.active = "Y";
	}
	
	/**
	 * @return the courseId
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	/**
	 * @return the courseDesc
	 */
	public String getCourseDesc() {
		return courseDesc;
	}
	/**
	 * @param courseDesc the courseDesc to set
	 */
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

}
