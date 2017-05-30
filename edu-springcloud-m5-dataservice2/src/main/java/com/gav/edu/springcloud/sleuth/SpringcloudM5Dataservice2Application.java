package com.gav.edu.springcloud.sleuth;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringcloudM5Dataservice2Application {
	
	@Autowired
	private Tracer tracer;

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM5Dataservice2Application.class, args);
	}
	
	@RequestMapping(value="/customer/{cid}/vehicledetails", method=RequestMethod.GET)
	public @ResponseBody String getCustomerVehicleDetails(@PathVariable Integer cid) {
		
		String result = "Unknown";
		
		Span span = this.tracer.createSpan("lookupvehicle");
		
		try {
			
			this.tracer.addTag("customerid", cid.toString());
			span.logEvent("Database query started here....");
			Thread.sleep(5000);
			
			
			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");			
			result = vehicles.get(cid);
			
			span.logEvent("Database query finished here.");
			
			
		} catch (InterruptedException e) {
			
		} finally {
			tracer.close(span);
		}
		
		return result;
	}
}
