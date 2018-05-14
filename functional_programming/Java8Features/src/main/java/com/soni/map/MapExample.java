package com.soni.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.soni.model.Employee;

public class MapExample {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			new Employee("John", 32),
			new Employee("Jenny", 23),
			new Employee("Joe", 29),
			new Employee("Jane", 32),
			new Employee("Justin", 26),
			new Employee("John", 32),
			new Employee("Johnathan", 22),
			new Employee("Juster", 24),
			new Employee("Jass", 20)
		);
			
		// map()
		List<String> firstNames = employees.stream().map(emp->{return emp.getName();}).collect(Collectors.toList());
		System.out.println("map() demonstration : ");
		firstNames.forEach(System.out::println);
		System.out.println("***************************************************************");
	}
}
