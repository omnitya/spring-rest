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
 * 
 */

@Entity
@Table(name = "save_point")
public class HelathCheckSavepoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long savepointId;
	private String restStatus;
	private String createdOn;
	private String updatedOn;
	private String healthMethod;
	
	public String getHealthMethod() {
		return healthMethod;
	}

	public void setHealthMethod(String healthMethod) {
		this.healthMethod = healthMethod;
	}

	public Long getSavepointId() {
		return savepointId;
	}

	public void setSavepointId(Long savepointId) {
		this.savepointId = savepointId;
	}



	public String getRestStatus() {
		return restStatus;
	}



	public void setRestStatus(String restStatus) {
		this.restStatus = restStatus;
	}



	public String getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}



	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}



	public HelathCheckSavepoint() {
		this.setCreatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	}
	
	public HelathCheckSavepoint(String restStatus) {
		this.setRestStatus(restStatus);
		this.setCreatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	}
	
	public HelathCheckSavepoint(String restStatus, String method) {
		this.setRestStatus(restStatus);
		this.setHealthMethod(method);
		this.setCreatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		this.setUpdatedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	}

}
