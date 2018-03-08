package jvx330.mod003.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "jvx330/mod003/ex1/mod003_1.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(config);
		
		Foo foo = context.getBean("foo2", Foo.class);
		System.out.println(foo.getRelationship());
		
		context.close();
	}
}
