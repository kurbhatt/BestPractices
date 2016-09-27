package org.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Keyur on 27-09-2016.
 * This class demonstrate how to sort HashMap by it's value
 */
public class SortMapByValue {

	public static void main(String[] args) {

		// unsorted map
		Map<String, Integer> unsortedMap = new HashMap<>();
		unsortedMap.put("B", 55);
		unsortedMap.put("A", 80);
		unsortedMap.put("D", 20);
		unsortedMap.put("C", 70);

		System.out.println("Before sorting......");
		printMapValue(unsortedMap);

		System.out.println("After sorting ascending order......");
		boolean ASCENDING = true;
		Map<String, Integer> sortedMapAsc = sortMapByComparator(unsortedMap, ASCENDING);
		printMapValue(sortedMapAsc);

		System.out.println("After sorting descending order......");
		boolean DESCENDING = false;
		Map<String, Integer> sortedMapDesc = sortMapByComparator(unsortedMap, DESCENDING);
		printMapValue(sortedMapDesc);

	}

	private static Map<String, Integer> sortMapByComparator(Map<String, Integer> unsortedMap, final boolean order) {

		List<Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (order) {
					return o1.getValue().compareTo(o2.getValue());
				} else {
					return o2.getValue().compareTo(o1.getValue());

				}
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	private static void printMapValue(Map<String, Integer> map) {
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}
