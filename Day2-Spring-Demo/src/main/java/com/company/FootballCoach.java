package com.company;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class FootballCoach implements ICoach{
	
	
	public FootballCoach()
	{
		System.out.println("In Constructor"+ getClass().getSimpleName() );
	}

	@PreDestroy
	public void Endingup() {
	    System.out.println("In Endingup() method: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkoutPlan() {
		
		return " practice fundamental techniques like dribbling, passing, shooting, and tackling.";
	}

}
