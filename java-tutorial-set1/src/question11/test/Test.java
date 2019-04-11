package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/config.xml");

		Employee emp = (Employee) context.getBean("myEmployeeBean");

		System.out.println(emp.toString());
	}
}
