package com.yeam;

public class Employee {
	private String department;
	private String name;
	private String phone;
	private String date;
	private int salary;
	
	
	public Employee(String department, String name,  String phone, String date, int salary) {
		this.department = department;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.salary = salary;
	}
		
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {		
		return  department + "\t" + name + "\t" + phone + "\t" + salary; 
	}
	
	
}
