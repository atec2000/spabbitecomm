/**
 * 
 */
package com.spabbitecomm.order.cron.jobs;

import com.spabbitecomm.order.cron.configuration.ConfigureQuartz;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author pavan.solapure
 *
 */
@Component
@DisallowConcurrentExecution
public class JobWithCronTrigger implements Job {

	private final static Logger logger = LoggerFactory.getLogger(JobWithCronTrigger.class);

	@Value("${cron.frequency.jobwithcrontrigger}")
	private String frequency;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		logger.info("Running JobWithCronTrigger | frequency {}", frequency);
	}

	@Bean(name = "jobWithCronTriggerBean")
	public JobDetailFactoryBean sampleJob() {
		return ConfigureQuartz.createJobDetail(this.getClass());
	}

	@Bean(name = "jobWithCronTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithCronTriggerBean") JobDetail jobDetail) {
		return ConfigureQuartz.createCronTrigger(jobDetail, frequency);
	}
}
