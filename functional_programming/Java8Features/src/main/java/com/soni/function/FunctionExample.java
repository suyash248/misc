package com.soni.function;

import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;

public class FunctionExample {

	public static void main(String[] args) {
		List<String> namesList = Arrays.asList("john", "jane", "foo", "bar");
		Function<String, String> convertoUpperFun = (firstName) -> { return firstName.toUpperCase(); };
		Function<String, Character> extractFirstFun = (firstName) -> { return firstName.charAt(0) ;};
		
		System.out.println("accept() demonstration : " + convertToUppercase(namesList, convertoUpperFun));
		
		
		Function<String, Character> andThenFun = convertoUpperFun.andThen(extractFirstFun);
		System.out.println("andThen() demonstration : " + extractFirst(namesList, andThenFun));
		
		
		Function<String, Character> composeFun = extractFirstFun.compose(convertoUpperFun);
		System.out.println("compose() demonstration : " + extractFirst(namesList, composeFun));
	}
	
	public static List<String> convertToUppercase(List<String> namesList, Function<String, String> convertoUpperFun) {
		List<String> uppercaseNames = new ArrayList<>();
		namesList.forEach(name -> {
			uppercaseNames.add(convertoUpperFun.apply(name));
		});
		return uppercaseNames;
	}
	
	// andThen() usage.
	public static List<Character> extractFirst(List<String> namesList, Function<String, Character> after) {
		List<Character> extractFirstList = new ArrayList<>();
		namesList.forEach(name -> {
			extractFirstList.add(after.apply(name));
		});
		return extractFirstList;
	}

}

/**
 * OUTPUT 
  	accept() demonstration : [JOHN, JANE, FOO, BAR]
	andThen() demonstration : [J, J, F, B]
	compose() demonstration : [J, J, F, B]
 */
