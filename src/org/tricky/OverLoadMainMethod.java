package org.tricky;

/**
 * Created by Keyur on 6/15/2016.
 */

public class OverLoadMainMethod {

	public static void main(Double[] args) {
		System.out.println("Inside main(Double[] args) method ....");
	}

	public static void main(String[] args) {
		System.out.println("Inside main(String[] args) method ....");
	}

	public static void main(Integer[] args) {
		System.out.println("Inside main(Integer[] args) method ....");
	}
}
