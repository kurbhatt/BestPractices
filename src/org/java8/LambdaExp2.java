package org.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.base.BaseClass;

/**
 * Created by Keyur on 07-10-2016.
 * This Class Demonstrate the functionality of Lambda Expression (Java 8).
 */
public class LambdaExp2 {

	public static void main(String[] args) {

		//Implement Functional Interface method and return list of instances that have matching values
		Integer matchValue = 1111;

		List<BaseClass> baseClasses = new ArrayList<>();

		BaseClass instance1 = new BaseClass();
		instance1.setMember1(111);
		instance1.setMember2(222);
		baseClasses.add(instance1);

		BaseClass instance2 = new BaseClass();
		instance2.setMember1(1111);
		instance2.setMember2(2222);
		baseClasses.add(instance2);

		FunctionInterfaceDemonstration count =
				(Integer value) -> baseClasses.stream().filter(baseClass -> baseClass.getMember1().equals(value))
						.collect(Collectors.toList());

		System.out.println("No. of matches found : " + count.countOnMe(matchValue).size());

		//Iterate List of Integers
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		//Way 1
		System.out.println("\n:: Way 1 ::");
		list.forEach(System.out::println);

		//Way 2
		System.out.println("\n:: Way 2 ::");
		list.forEach(n -> System.out.println(n));

		//Iterate List and calculate sum of members
		int sum = list.stream().reduce((x, y) -> x + y).get();
		System.out.println("\nSum of List Members : " + sum);
	}
}
