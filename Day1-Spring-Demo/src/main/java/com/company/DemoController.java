package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach coach;
	
//	@Autowired
//	public DemoController(@Qualifier("footballCoach") theCoach)
//	{
//		this.coach = theCoach;
//	}
//	
	@GetMapping("/workout")
	public String getDailyWorkoutPlan()
	{
		return coach.getDailyWorkoutPlan();
	}
	
}
