package com.client;

import com.client.service.*;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FirstClientApplication {

	@Autowired
	Vertx vertx;

	@Autowired
	private HelloClientMicroservice helloClientMicroservice;

	@Autowired
	private HelloConsumerMicroservice helloConsumerMicroservice;

	public static void main(String[] args) {
		SpringApplication.run(FirstClientApplication.class, args);
	}

	@EventListener
	public void deployServerVerticle(ApplicationReadyEvent event) {
		// vertx.deployVerticle(helloClientMicroservice);
		vertx.deployVerticle(helloConsumerMicroservice);
	}
}
