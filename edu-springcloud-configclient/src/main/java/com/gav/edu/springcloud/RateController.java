/**
 * 
 */
package com.gav.edu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alex
 *
 */
@Controller
public class RateController {
	
	@Value("${rate}")
	private String rate;
	@Value("${tolllane}")
	private String lanecount;
	@Value("${tollstart}")
	private String tollstart;
	@Value("${connstring}")
	private String connString;
	
	@RequestMapping("/rate")
	public String getRate(Model model) {
		model.addAttribute("rateamount", rate);
		model.addAttribute("lanecount", lanecount);
		model.addAttribute("tollstart", tollstart);
		model.addAttribute("connstring", connString);
		
		//name of the view
		return "rateview";
		
	}

}
