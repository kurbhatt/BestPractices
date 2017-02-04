package org.kur.practice.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.kur.practice.base.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrate the cache mechanism provide by google guava.
 * Created by Keyur on 4/2/17.
 */
public class CacheUtility {

    private static final Integer eID1= 1001;
    private static final Integer eID2= 1002;
    private static final Integer eID3= 1003;

    public static void main(String args[]) {
        LoadingCache<Integer, Employee> employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(20) //maximum 20 records can be cached
                        .expireAfterAccess(10, TimeUnit.MINUTES) //cache will expire after 10 minutes of access
                        .build(new CacheLoader<Integer, Employee>(){
                            @Override
                            public Employee load(Integer empId) throws Exception {
                                return loadDBData(empId); //call data load
                            }
                        });

        try {
            //on first call, cache will be populated with related data
            //employee record
            System.out.println("Call #1");
            System.out.println(employeeCache.get(CacheUtility.eID1));
            System.out.println(employeeCache.get(CacheUtility.eID2));
            System.out.println(employeeCache.get(CacheUtility.eID3));

            //second call, data will be returned from cache
            System.out.println("Call #2");
            System.out.println(employeeCache.get(CacheUtility.eID1));
            System.out.println(employeeCache.get(CacheUtility.eID2));
            System.out.println(employeeCache.get(CacheUtility.eID3));
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Employee loadDBData(Integer eID) {

        Employee emp1 = new Employee(CacheUtility.eID1, "Sunny Rajwadi", 50000.0, "Technical Architect");
        Employee emp2 = new Employee(CacheUtility.eID2, "Crisjaira Villarino", 30000.0, "Dev Ops");
        Employee emp3 = new Employee(CacheUtility.eID3, "Keyur Bhatt", 10000.0, "Full Stack Developer");

        Map<Integer, Employee> database = new HashMap<>();

        database.put(CacheUtility.eID1, emp1);
        database.put(CacheUtility.eID2, emp2);
        database.put(CacheUtility.eID3, emp3);

        System.out.println("Database hit for ID:: " + eID);
        return database.get(eID);
    }
}
