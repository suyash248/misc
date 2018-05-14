package com.soni.laziness;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.soni.model.Employee;

public class StreamLaziness {

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
		
		Stream<String> empStreams = employees.stream().map((emp)-> {
			return emp.getName();
		});
		
		IntStream.range(0, 5).forEach((i)->{
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});;
		
		System.out.println(empStreams.collect(Collectors.toList()));
	}

}
