package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 6};
        collapse(array);
    }
    private static void collapse(int[] arr){
        int[] array = new int[arr.length];
        int index = arr.length-1;
        int ind = 0;
        for (int i = 0; i < index; i++) {
            if (arr[i] != arr[i + 1]) {
                array[ind] = arr[i];
                ind++;
            }
        }
        array[ind] = arr[index];
        System.out.println(Arrays.toString(array));
    }
}