package com.ticket.concertticketmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ConcertTicketManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcertTicketManagementApplication.class, args);
	}

}
