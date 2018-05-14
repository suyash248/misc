package com.soni.ordering;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams can't be reused, a new stream must be generated each time. So here we have a Supplier for doing so.
 */
public class ReusingStreams {
	public static void main(String... args) {
		List<String> names = Arrays.asList("john", "penny", "joe", "justin", "jack", "jimmy", "james");
		List<String> uppercaseNames = getStream(names)
				.get().map((name)->name.toUpperCase()).collect(Collectors.toList());
		System.out.println(uppercaseNames);
		
		List<String> uppercaseNames1 = getStream("john", "penny", "joe", "justin", "jack", "jimmy", "james")
				.get().map((name)->name.toUpperCase()).collect(Collectors.toList());
		System.out.println(uppercaseNames1);
	}
	
	public static <T> Supplier<Stream<T>> getStream(List<T> list) {
		Supplier<Stream<T>> streamSupplier = ()-> list.stream();
		return streamSupplier;
	}
	
	public static <T> Supplier<Stream<T>> getStream(T... t) {
		Supplier<Stream<T>> streamSupplier = ()-> Stream.of(t);
		return streamSupplier;
	}
}

/*
OUTPUT - 

filter: d2
forEach: d2
filter: a2
forEach: a2
filter: b1
forEach: b1
filter: b3
forEach: b3
filter: c
forEach: c

*/