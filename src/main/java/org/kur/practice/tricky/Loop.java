package org.kur.practice.tricky;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyur on 23/10/18.
 * This Class Demonstrate the functionality of inner loop mechanism while using continue.
 */
public class Loop {

    public static void main(String[] args) {
        List<Integer> outerList = new ArrayList<>();
        outerList.add(10);
        outerList.add(20);
        outerList.add(30);

        List<Integer> innerList = new ArrayList<>();
        for(int i = 1; i<=10; i++) {
            innerList.add(i);
        }


        for(Integer outer : outerList) {
            System.out.println("Outer Iteration: " + outer);
            for(Integer inner: innerList) {
                if(inner == 5) {
                    continue;
                }
                System.out.println("Inner Iteration: " + inner);
            }
        }
    }
}
