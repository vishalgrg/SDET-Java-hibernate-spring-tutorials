package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.PaymentGateway;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext context  = new ClassPathXmlApplicationContext("resources/config.xml");
		
		PaymentGateway obj = (PaymentGateway)context.getBean("paymentGateway");
		System.out.println(obj.toString());
	}
}
