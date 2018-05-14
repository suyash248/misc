package com.soni.references;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MethodConstructorReferences {
	public static void main( String[] args ) {
		
		/*********************************************************************************************************************  
		 																									Lambda expression -> Method references 
		 *********************************************************************************************************************/
		
		MethodConstructorReferences mcr = new MethodConstructorReferences();
		List<String> list = new ArrayList<>();
		
		Comparator<String> comp = (o1, o2) -> {return Integer.valueOf(0);};								// Lambda
		Comparator<String> comp1 = MethodConstructorReferences :: customCompareTo;	// Static method reference
		Comparator<String> comp2 = mcr :: customInstanceCompareTo;										// Instance method reference
		
		
		Runnable runnable = ()  -> System.out.println("");											// Lambda
		Runnable runnable1 = MethodConstructorReferences :: customRun;	// Static method reference
		Runnable runnable2 = mcr :: customInstanceRun;										// Instance method reference
				
		Collections.sort(list,  comp);
		Collections.sort(list, (o1, o2) -> {
			return 0;
		});
		
		
		/*********************************************************************************************************************  
																										Lambda expression -> Constructor references 
		 *********************************************************************************************************************/
		
		
		/* The Java compiler automatically chooses the right constructor by matching the signature of PersonFactory.create.  */
		// Using Constructor Reference.
		PersonFactory personFactory = Person::new;
		personFactory.create("Suyash", "Soni");
		
		// Using Lambda.
		PersonFactory personFactory1 = (fName, lName) -> {
			return new Person(fName, lName);
		};
		personFactory1.create("Suyash", "Soni");
    }
	
	public static void customRun() {
		System.out.println("Inside run method.");
	}
	
	public void customInstanceRun() {
		System.out.println("Inside run method.");
	}
	
	public static <T extends Comparable<T>> int customCompareTo(T o1, T o2) {
		return o1.compareTo(o2);
	}
	
	public  <T extends Comparable<T>> int customInstanceCompareTo(T o1, T o2) {
		return o1.compareTo(o2);
	}
}

class Person {
	public String firstName;
	public String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

interface PersonFactory {
	Person create(String fName, String lName);
}
