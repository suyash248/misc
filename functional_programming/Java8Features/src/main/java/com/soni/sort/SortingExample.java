package com.soni.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.soni.model.Employee;

public class SortingExample {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			new Employee("John", 32),
			new Employee("Jenny", 23),
			new Employee("Joe", 29),
			new Employee("Jane", 32),
			new Employee("Justin", 26),
			new Employee("John", 46),
			new Employee("Johnathan", 22),
			new Employee("Juster", 24),
			new Employee("Jass", 20)
		);
		
		List<Employee> sortByName = employees.stream().sorted().collect(Collectors.toList());
		System.out.println("Sort by name : \n" + sortByName);
		
		List<Employee> sortByAge = employees.stream().sorted((e1, e2)->{
			if(e1.getAge()==e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}
			return Integer.valueOf(e1.getAge()).compareTo(e2.getAge());
		}).collect(Collectors.toList());
		
		System.out.println("\n******************************\n");
		
		System.out.println("Sort by age : \n" + sortByAge);
	}
}
