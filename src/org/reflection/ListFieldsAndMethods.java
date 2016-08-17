package org.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.base.BaseClass;

/**
 * This Class will try to List the declared fields and methods of BaseClass using Reflection.

 * Created by Keyur on 6/15/2016.
 */

public class ListFieldsAndMethods {

	public static void main(String[] args) throws Exception {

		Field[] fields = BaseClass.class.getDeclaredFields();
		Method[] methods = BaseClass.class.getDeclaredMethods();

		System.out.println(":: METHOD ::");
		for(Method method : methods){
			System.out.println(method.toString());
		}

		System.out.println("\n\n:: FIELD ::");
		for(Field field : fields){
			System.out.println(field.getName());
		}
	}
}
