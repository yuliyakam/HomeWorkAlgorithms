package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 3, 2, 0, 3, 3, 2, 1, 0, 1, 0};
        System.out.println(Arrays.toString(countSort(array)));
    }

    private static int[] countSort(int[] arr) {
        int[] resulrArr = new int[4];
        for (int j = 0; j < resulrArr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == j)
                    resulrArr[j]++;
            }
        }
        int step = 0;
        for (int j = 0; j < resulrArr.length; j++) {
            for (int i = 0; i < resulrArr[j]; i++) {
                arr[step] = j;
                step++;
            }
        }
        return arr;
    }
}