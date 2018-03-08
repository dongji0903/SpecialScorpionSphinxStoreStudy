package jvx330.mod003.ex3;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AddressInfoList {
	private List<String> addrList;
	
	public List<String> getAddrList() {
		return addrList;
	}
	
	public void setAddrList(List<String> addrList) {
		this.addrList = addrList;
	}
	
	public static void main(String[] args) {
		String config = "jvx330/mod003/ex3/mod003_3.xml"; 
		AbstractApplicationContext context = new GenericXmlApplicationContext(config);
		
		AddressInfoList addrList = context.getBean("addrList", AddressInfoList.class);
		for(String s : addrList.getAddrList()) {
			System.out.println(s);
		}
		
		context.close();
	}
}
