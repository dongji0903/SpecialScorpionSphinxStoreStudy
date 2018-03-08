package jvx330.mod003.ex1;

public class Foo {
	private Bar bar;
	
	public Foo() {
		System.out.println("Foo() is called");
	}
	
	/*public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) is called");
	}*/
	
	public String getRelationship() {
		return "Foo has relationship with " + bar;
	}
	
	public void setBar(Bar bar) { //생성자에 아규먼트 넣는 대신 이거 쓰면 된당
		this.bar = bar;
	}
}
