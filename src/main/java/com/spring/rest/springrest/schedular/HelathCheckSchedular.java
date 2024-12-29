/**
 * 
 */
package com.spring.rest.springrest.schedular;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.rest.springrest.Service.CourseService;

/**
 * 
 */

@Component
public class HelathCheckSchedular {
	
	private static final Logger logger = LoggerFactory.getLogger(HelathCheckSchedular.class);
	
	private String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss.SSS";
	
	@Autowired
	private CourseService courseService;
	
	@Scheduled(cron = "${health.check.cron}")
	public void scheduleTask() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

	    String strDate = dateFormat.format(new Date());
	    
	    courseService.saveHealthStatus("SCHEDULAR CRON");

	    logger.info("Cron job Scheduler: Job running at :: {}, health as :: 200 OK", strDate);
	    
	}
	
}
