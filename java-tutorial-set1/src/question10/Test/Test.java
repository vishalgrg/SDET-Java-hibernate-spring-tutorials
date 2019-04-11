package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/bean.cfg.xml");
		Employee employee = (Employee) context.getBean("myEmployee");
		System.out.println(employee.toString());
	}

}
