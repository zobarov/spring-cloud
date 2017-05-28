package com.gav.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EduSpringcloudConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduSpringcloudConfigserverApplication.class, args);
	}
}
