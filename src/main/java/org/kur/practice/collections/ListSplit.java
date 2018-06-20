package org.kur.practice.collections;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyur on 20/6/18.
 * This class demonstrate to split list element in sublist
 */
public class ListSplit {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 147 ; i++){
            list.add(i);
        }
        System.out.println("Total List Size: " + list.size());

        List<List<Integer>> partition = Lists.partition(list, 10);
        for(List<Integer> chunk : partition){
            System.out.println("Sub List Size: " + chunk.size());
        }
    }
}
