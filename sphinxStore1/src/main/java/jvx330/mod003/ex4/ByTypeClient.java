package jvx330.mod003.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ByTypeClient {
	private NamingService namingService;

	public NamingService getNamingService() {
		return namingService;
	}

	public void setNamingService(NamingService namingService) {
		this.namingService = namingService;
	}
	
	public void service(String name) {
		Object o = namingService.lookup(name);
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		String config = "jvx330/mod003/ex4/byType.xml"; 
		AbstractApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByTypeClient byType = context.getBean("byTypeClient", ByTypeClient.class);
		byType.service("화연");
		
		context.close();
	}
}
