package org.kur.practice.java8;

import org.kur.practice.base.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by Keyur on 15/10/18.
 * This Class Demonstrate the functionality of Java 8 parallel stream in thread safe environment.
 */
public class ParallelStream {

    static int l = 0;
    public static void main(String[] args) {
        letsGoParallel();
    }

    synchronized static int makeSomeMagic(int data) {
        l++;
        return data * 100;
    }

    static void letsGoParallel() {
        List<Integer> dataList = new ArrayList<>();
        for(int i = 1; i <= 100 ; i++) {
            dataList.add(i);
        }
        Map<Integer, Integer> resultMap = new ConcurrentHashMap<>();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Keyur", 10000.0, "S/W Er."));
        employees.add(new Employee(2, "Keyur1", 20000.0, "1 S/W Er."));
        employees.add(new Employee(3, "Keyur2", 30000.0, "2 S/W Er."));
        employees.add(new Employee(4, "Keyur3", 40000.0, "3 S/W Er."));

        List<SampleResult> result = employees.parallelStream().map(f -> {
            int x = makeSomeMagic(f.getId());
            resultMap.put(f.getId(), x);
            return new SampleResult(f.getId(), x);
        }).collect(Collectors.toList());

        System.out.println("Input Size: " + dataList.size());
        System.out.println("Result Size: " + resultMap.size());
        System.out.println("Result 1 Size: " + result.size());
        System.out.println("Function Called: " + l);
    }

    static class SampleResult {
        private Integer id;
        private Integer result;

        public SampleResult() {
        }

        public SampleResult(Integer id, Integer result) {
            this.id = id;
            this.result = result;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }
    }
}
