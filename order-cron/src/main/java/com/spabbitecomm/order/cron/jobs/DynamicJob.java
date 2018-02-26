/**
 * 
 */
package com.spabbitecomm.order.cron.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pavan.solapure
 *
 */
@DisallowConcurrentExecution
public class DynamicJob  implements Job {
	
	private final static Logger logger = LoggerFactory.getLogger(DynamicJob.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("----- Running Dynamic Job With Simple Trigger ------");
	}

}
