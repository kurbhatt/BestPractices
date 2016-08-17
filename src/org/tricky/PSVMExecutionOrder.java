package org.tricky;

/**
 * This class will try to demonstrate the execution order of various blocks as well as java's main method.
 *
 * Created by Keyur on 6/15/2016.
 */

public class PSVMExecutionOrder {

	static {
		System.out.println("top static block executed");
	}

	public static void main(String[] args) {
		System.out.println("public static void main executed");
	}

	static {
		System.out.println("bottom static block executed");
	}
}
