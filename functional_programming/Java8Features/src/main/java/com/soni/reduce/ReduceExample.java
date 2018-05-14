package com.soni.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.soni.model.Employee;

public class ReduceExample {
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("C", "Java", "Ruby", "Python", "Erlang", "Scala");
		Optional<String> optional = languages.stream().reduce((l1, l2)-> {return l1+ " " + l2;});
		optional.ifPresent((lang)->{System.out.println(lang);});
		
		String langVal = optional.get();
		System.out.println(langVal);
		System.out.println("\n***************************************************************\n");
		
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
		
		employees.stream().reduce((e1, e2)->{
			e1.setAge(e1.getAge() + e2.getAge());
			e1.setName(e1.getName() + " | " + e2.getName());
			return e1;
		}).ifPresent((reducedEmployee)->{System.out.println(reducedEmployee);});
		
		System.out.println("\n***************************************************************\n");
		
		employees.stream()
			.map((emp)-> emp.getAge())
			.reduce((e1Age, e2Age)-> {return e1Age + e2Age;})
			.ifPresent((reducedEmpAgeSum)-> System.out.println(reducedEmpAgeSum));
		
		System.out.println("\n***************************************************************\n");
		
		Integer totalAgeSum = employees.stream()
		.map((emp)-> emp.getAge())
		.reduce(0, (e1Age, e2Age)-> {return e1Age + e2Age;});
		System.out.println(totalAgeSum);
	
		System.out.println("\n***************************************************************\n");
	}
}

/* OUTPUT - 
 
	C Java Ruby Python Erlang Scala
	C Java Ruby Python Erlang Scala
	
	***************************************************************
	
	Employee(name=John | Jenny | Joe | Jane | Justin | John | Johnathan | Juster | Jass, age=254)
	
	***************************************************************
	
	476
	
	***************************************************************
	
	476
	
	***************************************************************

*/

/*
The Stream.reduce method is a general-purpose reduction operation. Consider the following pipeline, which calculates the sum of the male members' ages in the collection roster. It uses the Stream.sum reduction operation:

Integer totalAge = roster
    .stream()
    .mapToInt(Person::getAge)
    .sum();
Compare this with the following pipeline, which uses the Stream.reduce operation to calculate the same value:

Integer totalAgeReduce = roster
   .stream()
   .map(Person::getAge)
   .reduce(
       0,
       (a, b) -> a + b);
The reduce operation in this example takes two arguments:

identity: The identity element is both the initial value of the reduction and the default result if there are no elements in the stream. In this example, the identity element is 0; this is the initial value of the sum of ages and the default value if no members exist in the collection roster.

accumulator: The accumulator function takes two parameters: a partial result of the reduction (in this example, the sum of all processed integers so far) and the next element of the stream (in this example, an integer). It returns a new partial result. In this example, the accumulator function is a lambda expression that adds two Integer values and returns an Integer value:

(a, b) -> a + b
*/