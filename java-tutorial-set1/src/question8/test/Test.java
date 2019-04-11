package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import config.ApplicationConfig;
import config.MyDBConfig;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		MyDBConfig config = (MyDBConfig) context.getBean("dbConfig");

		System.out.println(config.toString());
	}
}
