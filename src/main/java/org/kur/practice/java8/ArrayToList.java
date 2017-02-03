package org.kur.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Keyur on 13/12/16.
 * This Class Demonstrate the functionality of Stream to convert primitive array to List (Java 8).
 */
public class ArrayToList {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println("Converted list is =  " + intList);
    }
}
