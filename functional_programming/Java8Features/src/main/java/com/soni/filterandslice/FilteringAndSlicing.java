package com.soni.filterandslice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.soni.model.Employee;

public class FilteringAndSlicing {

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
		
		// filter
		employees = employees.stream().filter((emp)->{
			return emp.getAge()>24;
		}).collect(Collectors.toList());
		System.out.println("After filter() size : " + employees.size());
		employees.forEach(System.out::println);
		System.out.println("**************************************************************************");
		
		// distinct
		employees = employees.stream().distinct().collect(Collectors.toList());
		System.out.println("After distinct() size : " + employees.size());
		employees.forEach(System.out::println);
		System.out.println("**************************************************************************");
		
		// limit
		employees = employees.stream().limit(3).collect(Collectors.toList());
		System.out.println("After limit() size : " + employees.size());
		employees.forEach(System.out::println);
		System.out.println("**************************************************************************");
		
		// skip
		employees = employees.stream().skip(2).collect(Collectors.toList());
		System.out.println("After skip() size : " + employees.size());
		employees.forEach(System.out::println);
		System.out.println("**************************************************************************");
	}
}

/*
OUTPUT - 
	After filter() size : 5
	Employee(name=John, age=32)
	Employee(name=Joe, age=29)
	Employee(name=Jane, age=32)
	Employee(name=Justin, age=26)
	Employee(name=John, age=32)
	**************************************************************************
	After distinct() size : 4
	Employee(name=John, age=32)
	Employee(name=Joe, age=29)
	Employee(name=Jane, age=32)
	Employee(name=Justin, age=26)
	**************************************************************************
	After limit() size : 3
	Employee(name=John, age=32)
	Employee(name=Joe, age=29)
	Employee(name=Jane, age=32)
	**************************************************************************
	After skip() size : 1
	Employee(name=Jane, age=32)
	**************************************************************************
*/