package com.company;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component

public class CricketCoach implements ICoach{

	
	public CricketCoach()
	{
		System.out.println("In Constructor"+ getClass().getSimpleName() );
	}
	
	@PostConstruct
	public void startup() {
	    System.out.println("In Startup() method: " + getClass().getSimpleName());
	}
	
	
	
	@Override
	public String getDailyWorkoutPlan() {
		
		return "focus on regular practice of batting, bowling, and fielding techniques. ";
	}

}
