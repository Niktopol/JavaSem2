package com.example.demo;

import com.example.demo.component.Musician;
import com.example.demo.configuration.BeanConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		context.getBean(args[0], Musician.class).doCoding();
	}

}
