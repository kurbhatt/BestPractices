package org.kur.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Keyur on 24/7/17.
 * This Class Demonstrate Convert 1 Collection Implementation to Another.
 */
public class StreamConvertCollectionType {

    public static void main(String[] args) {
        List<Long> numbers = new ArrayList<>();
        numbers.add(1L);
        numbers.add(2L);
        numbers.add(3L);
        numbers.add(4L);

        List<Integer> castedNumbers = convertList(numbers, Long::intValue);

        castedNumbers.forEach(System.out::println);
    }

    private static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }
}
