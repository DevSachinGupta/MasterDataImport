package com.csvprocessor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterImportJobInvokerController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job csvDataImportJob;
	
	@RequestMapping("/invokeJob")
	public String invokeCsvImportJob() throws Exception {
		
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(csvDataImportJob, jobParameters);
		
		return "Batch job has been initialized !!!!";
	}
	
	@RequestMapping("/")
	public String invokeCsvImportJob() throws Exception {
		
		return "<div><h1>Hello, Welcome to CSV 2 DB</h1><a href="/invokeJob">Invoke Job</a></div>";
	}
}
