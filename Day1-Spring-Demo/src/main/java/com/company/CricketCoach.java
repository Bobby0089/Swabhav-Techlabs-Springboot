package com.company;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkoutPlan() {

		return "Practice batting and bowling for one1 hour";
	}

}
