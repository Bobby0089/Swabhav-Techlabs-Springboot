package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.company.service.EmailSenderService;

@SpringBootApplication
public class SpringBootEmailApplication {

	@Autowired
	private EmailSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail()
	{
		senderService.sendEmail("learnings.bobby.0089@gmail.com", "this is the subject of email", "this is the body of email");
	}
}
