package com.soni.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		List<String> namesList = Arrays.asList("john", "jane", "foo", "bar");
		
		Consumer<String> uppercaseConsumer = (name) -> { System.out.print(name.toUpperCase() + " "); };
		Consumer<String> extractFirstCharConsumer = (name) -> { System.out.print(name.substring(0, 1) + " "); };
		
		
		System.out.print("accept() demonstration : ");
		consume(namesList, uppercaseConsumer);
		
		
		Consumer<String> andThenConsumer = uppercaseConsumer.andThen(extractFirstCharConsumer);
		System.out.print("\nandThen() demonstration : ");
		consume(namesList, andThenConsumer);
	}
	
	public static void consume(List<String> namesList, Consumer<String> consumer) {
		namesList.forEach(name -> {
			consumer.accept(name);
		});
	}
}
