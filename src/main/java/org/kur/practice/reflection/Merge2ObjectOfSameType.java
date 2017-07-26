package org.kur.practice.reflection;

import org.kur.practice.base.Employee;

import java.lang.reflect.Method;

/**
 * Created by Keyur on 26/7/17.
 * This class demonstrates the merge of 2 objects of same type.
 */
public class Merge2ObjectOfSameType {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setId(1);
        e1.setName("name");

        e2.setDesignation("designation");
        e2.setSalary(100.0);

        merge(e1, e2);

        System.out.println("E1:" + e1.toString());
        System.out.println("E2:" + e2.toString());
    }

    private static void merge(Object obj, Object update){
        if(!obj.getClass().isAssignableFrom(update.getClass())){
            return;
        }
        Method[] methods = obj.getClass().getMethods();

        for(Method fromMethod: methods){
            if(fromMethod.getDeclaringClass().equals(obj.getClass())
                    && fromMethod.getName().startsWith("get")){

                String fromName = fromMethod.getName();
                String toName = fromName.replace("get", "set");

                try {
                    Method toMetod = obj.getClass().getMethod(toName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(update, (Object[])null);
                    if(value != null){
                        toMetod.invoke(obj, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
