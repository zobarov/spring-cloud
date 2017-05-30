package com.gav.edu.sprincloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class EduSpringcloudM5ZipkinserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduSpringcloudM5ZipkinserverApplication.class, args);
	}
}
