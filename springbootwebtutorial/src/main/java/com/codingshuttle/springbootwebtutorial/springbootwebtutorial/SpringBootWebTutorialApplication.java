package com.codingshuttle.springbootwebtutorial.springbootwebtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringBootWebTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebTutorialApplication.class, args);

		//Stream understanding
		List<String> fruits = List.of("mango", "apple", "banana");
		fruits.forEach(fruit -> {
			System.out.println(fruit);
		});

		System.out.println("---- After sorting ----");
		fruits.stream().sorted().forEach(fruit -> System.out.println(fruit));

		//Use Map when we want to convert a stream to another stream

		System.out.println("------Using the Map--------");
		fruits.stream()
				.sorted()
				.map(fruit -> 2 * fruit.length())
				.forEach(fruit -> System.out.println(fruit));


		System.out.println("-------using the collectorlist ------");

		List<Integer> fruitList = fruits.stream()
				.sorted()
				.map(fruit -> 2 * fruit.length())
				.toList();

		System.out.println("fruitList is " + fruitList);

		System.out.println("-------convert fruit streams to the Map ------");

		Map<String, Integer> fruitMap = fruits.stream()
				.collect(Collectors.toMap(
						fruit -> fruit,
						       fruit -> fruit.length()
				));
		System.out.println(fruitMap);
	}

}
