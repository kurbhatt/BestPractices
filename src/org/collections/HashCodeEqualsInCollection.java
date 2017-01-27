package org.collections;

import org.base.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Keyur on 26/1/17. This Class Demonstrate the functionality of hashCode method and
 * equals method
 * 1. To store unique results in Set, we have to implement hashCode and equals methods
 * on specific field. In our case it's employee id and employee name.
 * 2. List does not manage unique records.
 */
public class HashCodeEqualsInCollection {
    public static void main(String[] args) {

        Set<Employee> employeeSet = new HashSet<>();
        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Name");
        e1.setSalary(100000.0);
        e1.setDesignation("Sr. Engineer");
        employeeSet.add(e1);
        employeeList.add(e1);

        Employee e2 = new Employee();
        e2.setId(1);
        e2.setName("Name");
        e2.setSalary(100000.0);
        e2.setDesignation("Sr. Engineer");
        employeeSet.add(e2);
        employeeList.add(e2);

        System.out.println(employeeSet.size());
        System.out.println(employeeList.size());
    }
}
