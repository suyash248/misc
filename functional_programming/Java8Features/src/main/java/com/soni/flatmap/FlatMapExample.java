package com.soni.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// flatMap() is used to convert a Stream of Stream into a list of values
public class FlatMapExample {

	public static void main(String[] args) {
		List<String> wigzoEmployees = Arrays.asList("Ankit", "Rohit", "Vikram", "Min");
		List<String> dlsEmployees = Arrays.asList("Sawan", "Vivek", "Anjal");
		List<String> cognizantEmployees = Arrays.asList("Vyomesh", "Suraj", "Abhinav");
		
		List<List<String>> allOrgs = new ArrayList<>();
		allOrgs.add(wigzoEmployees);
		allOrgs.add(dlsEmployees);
		allOrgs.add(cognizantEmployees);
		
		List<String> humansList = allOrgs.stream().flatMap(emp -> emp.stream()).collect(Collectors.toList());
		System.out.println(humansList);
	}
}

/*
	OUTPUT - 
	[Ankit, Rohit, Vikram, Min, Sawan, Vivek, Anjal, Vyomesh, Suraj, Abhinav]
 */
