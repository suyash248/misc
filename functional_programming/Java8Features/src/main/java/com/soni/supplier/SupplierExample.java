package com.soni.supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
	
	public SupplierExample() {
		System.out.println("Supplier using constructor reference.");
	}
	
	static List<String> namesList = Arrays.asList("john", "jane", "foo", "bar");
	public static void main(String[] args) {
		List<String> upperCaseList = new ArrayList<>();
		
		Supplier<List<String>> getFirstCharSupplier = ()-> {
			namesList.forEach(name -> {
				upperCaseList.add(name.toUpperCase());
			});
			return upperCaseList;
		};
		
		// Supplier using constructor reference.
		Supplier<SupplierExample> consRefSupplier = SupplierExample::new;
		
		// Supplier using method reference.
		Supplier<List<String>> extractFirstChar = SupplierExample::getFirstChar;
	}
	
	public static List<String> getFirstChar() {
		List<String> firstCharList = new ArrayList<>();
		namesList.forEach(name -> {
			firstCharList.add(name.substring(0, 1));
		});
		return firstCharList;
	}
}
