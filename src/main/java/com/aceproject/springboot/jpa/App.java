package com.aceproject.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties(FreeMarkerProperties.class)
public class App {
    public static void main( String[] args ) {
        if (args.length < 1) {
			System.err.println("require 1 argument config location. [ local ]");
			return;
		}
        
        String arg = args[0];
        
        if (!"local".equals(arg)) {
        	System.err.println("invalid argument. (" + arg);
			return;
		}
        
       
		String location = new StringBuilder()
				.append("--spring.config.location=classpath:/config/")
				.append(arg).append("/application.properties").toString();
		args[0] = location;

		
		SpringApplication.run(App.class, args);
		
		System.out.println("Hello World! ");
    }
}
