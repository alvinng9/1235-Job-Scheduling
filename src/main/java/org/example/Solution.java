package org.example;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] array = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            array[i][0] = startTime[i];
            array[i][1] = endTime[i];
            array[i][2] = profit[i];
        }
        Arrays.sort(array, (a, b) -> {
            return a[1]- b[1];
        });
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(0, 0);
        for (int[] here : array) {
            int temp = tree.floorEntry(here[0]).getValue() + here[2];
            if (temp > tree.lastEntry().getValue()) {
                tree.put(here[1], temp);
            }
        }
        return tree.lastEntry().getValue();
    }
}
