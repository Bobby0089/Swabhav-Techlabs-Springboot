package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private ICoach coach;
	private ICoach coach2;
	
	@Autowired
	public DemoController(@Qualifier("cricketCoach") ICoach theCoach, @Qualifier("footballCoach")ICoach theCoach2)	
	{
		this.coach = theCoach;
		this.coach2 = theCoach2;
		
	}
	
//	@Autowired
//	public DemoController(@Qualifier("footballCoach") ICoach theCoach, @Qualifier("footballCoach")ICoach theCoach2)
//	{
//		this.coach = theCoach;
//		this.coach2 = theCoach2;
//	}
	
//	public DemoController(@Qualifier("cricketCoach")ICoach coach,@Qualifier("cricketCoach")ICoach coach2) {
//		this.coach = coach;
//		this.coach2 = coach2;
//	}
	
	
	
	@GetMapping("/check")
	public boolean check()
	{
		return coach == coach2;
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return coach.getDailyWorkoutPlan();
	}
}
