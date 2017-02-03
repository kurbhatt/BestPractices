package org.kur.practice.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class Demonstrate the Basic Conversion of ArrayList to Array.
 * Created by Keyur on 5/1/17.
 */
public class ArrayListToArray {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Data 1");
        list.add("Data 2");
        list.add("Data 3");
        list.add("Data 4");
        list.add("Data 5");

        String[] array = list.toArray(new String[0]);

        for (String s : array) {
            System.out.println(s);
        }
    }
}
