package question7.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MyConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/appContext.xml");

		MyConfig config = (MyConfig) context.getBean("dbConfig");

		System.out.println(config.toString());
	}
}
