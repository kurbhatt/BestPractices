package org.property_loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Keyur on 6/1/17.
 * This Class Demonstrate to Load and Parse CSV data from properties file and convert it to Integer List.
 */
public class PropertyLoaderForCSV {
    private static Properties properties;

    public static void main(String[] args) {
        try {
            properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/csvfile.properties"));

            String ids = properties.getProperty("ids");
            String[] splittedIDs = ids.split(",");

            List<Integer> list1 = convertUsingJava7(splittedIDs);
            System.out.println("Way 1");
            System.out.println(list1);

            List<Integer> list2 = convertUsingJava8Way1(splittedIDs);
            System.out.println("Way 2");
            System.out.println(list2);

            List<Integer> list3 = convertUsingJava8Way2(splittedIDs);
            System.out.println("Way 3");
            System.out.println(list3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<Integer> convertUsingJava7(String[] splited){
        List<Integer> list = new ArrayList<>();
        for(String s: splited){
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    static List<Integer> convertUsingJava8Way1(String[] splited){
        return Stream.of(splited).map(Integer::parseInt).collect(Collectors.toList());
    }

    static List<Integer> convertUsingJava8Way2(String[] splited){
        List<Integer> list = new ArrayList<>();
        Arrays.stream(splited).forEach((i) -> {list.add(Integer.valueOf(i));});
        return list;
    }
}
