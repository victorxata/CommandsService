package ie.vhi.common.services.commands;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EnableAutoConfiguration //defines this as a Spring Boot application
@SpringBootApplication
public class CommandsServiceServer extends SpringBootServletInitializer {


	protected Logger logger = Logger.getLogger(CommandsServiceServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 *
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Tell server to look for commandsService-server.yml
		System.setProperty("spring.config.name", "commandsService-server.yml");

		SpringApplication.run(CommandsServiceServer.class, args);
	}
}
