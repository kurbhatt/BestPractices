package org.kur.practice.reflection;

import java.lang.reflect.Field;

import org.kur.practice.base.BaseClass;

/**
 * This Class will try to access the private members of BaseClass using Reflection without getters.
 * Created by Keyur on 6/15/2016.
 */

public class PrivateMemberValueWithoutGetterSetter {

	public static void main(String[] args) throws Exception {

		BaseClass instance = new BaseClass();
		instance.setMember1(222);
		instance.setMember2(333);

		Field[] fields = BaseClass.class.getDeclaredFields();

		for(Field field : fields){
			field.setAccessible(true);

			Object val = field.get(instance);
			System.out.println("fName :: " + field.getName() + " : fValue :: " + val);
		}

	}
}
