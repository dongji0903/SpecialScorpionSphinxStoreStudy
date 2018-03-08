package jvx330.mod003.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "jvx330/mod003/ex2/mod003_2.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(config);
		
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee.getDetail());
		
		context.close();
	}
}
