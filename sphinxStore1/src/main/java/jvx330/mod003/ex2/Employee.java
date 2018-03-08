package jvx330.mod003.ex2;

public class Employee {
	private String name;
	private Dept dept;
	private double salary;
	private Date regDate;
	
	public Employee(String name, Dept dept, double salary, Date regDate) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.regDate = regDate;
		System.out.println("이거");
	}
	
	public String getDetail() {
		return "Employee [name = " + name + ", Dept = " + dept + ", salary = " + salary + ", regDate = " + regDate + "]";
	}
	
}
