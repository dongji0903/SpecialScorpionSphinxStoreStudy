package jvx330.mod002;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "jvx330/mod002/mod002.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(config);
		
		Hello hello = context.getBean("helloBean", Hello.class);
		System.out.println(hello.sayHello("Spring"));
		
		context.close();
	}
}
