package com.soni.match;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("C", "Java", "Ruby", "Python", "Erlang", "Scala");
		
		boolean result1 = languages.stream().anyMatch((lang)->{return lang.startsWith("J");});
		boolean result2 = languages.stream().allMatch((lang)->{return lang.startsWith("J");});
		boolean result3 = languages.stream().noneMatch((lang)->{return lang.startsWith("J");});
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
}
