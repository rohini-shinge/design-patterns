package com.builder.impl;

class Employee {

	// Address
	String landmark, city, state;
	// Employment
	String position, company;

	@Override
	public String toString() {
		return "Employee [landmark=" + landmark + ", city=" + city + ", state=" + state + ", position=" + position
				+ ", company=" + company + "]";
	}

}

class EmployeeBuilder1 {

	Employee employee = new Employee();

	public EmployeeAddressBuilder lives() {
		return new EmployeeAddressBuilder(employee);
	}

	public EmployeeProfessionBuilder works() {
		return new EmployeeProfessionBuilder(employee);
	}

	public Employee build() {
		return this.employee;
	}

}

class EmployeeAddressBuilder extends EmployeeBuilder1 {

	public EmployeeAddressBuilder(Employee employee) {

		this.employee = employee;
	}

	public EmployeeAddressBuilder landmark(String landmark) {
		employee.landmark = landmark;
		return this;
	}

	public EmployeeAddressBuilder city(String city) {
		employee.city = city;
		return this;
	}

	public EmployeeAddressBuilder state(String state) {
		employee.state = state;
		return this;
	}

}

class EmployeeProfessionBuilder extends EmployeeBuilder1 {

	public EmployeeProfessionBuilder(Employee employee) {

		this.employee = employee;
	}

	public EmployeeProfessionBuilder position(String position) {
		employee.position = position;
		return this;
	}

	public EmployeeProfessionBuilder company(String company) {
		employee.company = company;
		return this;
	}

}

public class FacetedBuilderDemo {

	public static void main(String[] args) {

		EmployeeBuilder1 builder = new EmployeeBuilder1();
		Employee employee = builder.lives().landmark("Eastern Paradise").city("Pune").state("MH").works().position("SE")
				.company("Zycus").build();
		System.out.println(employee);

	}

}
