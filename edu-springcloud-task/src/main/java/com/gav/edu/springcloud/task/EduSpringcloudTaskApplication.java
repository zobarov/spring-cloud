package com.gav.edu.springcloud.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class EduSpringcloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduSpringcloudTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollTask() {
		return new TollProcessingTask();
	}
	
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			
			if(null != strings) {
				System.out.println("Parameters are:" + strings); 
				
				String stationId = strings[0];
				String licensePlate = strings[1];
				String timestamp = strings[2];
				
				System.out.println("StationId is " + stationId + ", licensePl is " + licensePlate + ", time:" + timestamp);
			}
			
		}
		
	}
}
