package org.example.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class NonDuplicatInstance {

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 3, 6, 9, 9};
        int count = moveElements(arr);
    }
    public static int moveElements(int[] arr) {
        // TODO: Write your code here
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< arr.length; i++) {
            if(!map.containsKey(arr[i])){
                count++;
                map.put(arr[i], i);
            }
        }
        System.out.println(map.keySet());
        return count;
    }
}
