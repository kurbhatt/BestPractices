package org.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Keyur on 19-10-2016.
 */
public class MapSortByKey {

	public static void main(String[] argv) {

		Map<String, Integer> unsortedMap = new HashMap<>();

		unsortedMap.put("z", 10);
		unsortedMap.put("b", 5);
		unsortedMap.put("a", 6);
		unsortedMap.put("c", 20);
		unsortedMap.put("d", 1);
		unsortedMap.put("e", 7);
		unsortedMap.put("y", 8);
		unsortedMap.put("n", 99);
		unsortedMap.put("j", 50);
		unsortedMap.put("m", 2);
		unsortedMap.put("f", 9);

		System.out.println(":: Un Sorted Map ::");
		System.out.println(unsortedMap);

		Map<String, Integer> sortedMap = new LinkedHashMap<>();

		//sort by key, a,b,c,... and put it into the "sortedMap" map
		unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		System.out.println(":: Sorted Map ::");
		System.out.println(sortedMap);
	}
}
