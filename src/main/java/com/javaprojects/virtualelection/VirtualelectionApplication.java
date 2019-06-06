package com.javaprojects.virtualelection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.javaprojects.virtualelection.controller"})
public class VirtualelectionApplication {
	public static void main(String[] args) {
		SpringApplication.run(VirtualelectionApplication.class, args);
	}
}