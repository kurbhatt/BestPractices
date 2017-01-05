package org.collections;

import java.util.Arrays;
import java.util.List;

/**
 * This Class Demonstrate To Convert Comma Separated String to List.
 * Created by Keyur on 5/1/17.
 */
public class CommaSeparatedStringToList {
    public static void main(String[] args) {
        String commaSeparated = "a@a.com,b@b.com,c@c.com";

        List<String> list = Arrays.asList(commaSeparated.split(","));

        list.forEach(System.out::println);
    }
}
