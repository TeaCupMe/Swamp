package com.company;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public int binarySearch(int[] numList, int target) {
        Arrays.sort(numList);
        boolean found = false;
        int pivot = (numList.length+1)/2;
        int upper = 
        while (numList[pivot] != target) {
            if (numList[pivot] > target) {
                pivot = (pivot+1)/2;
            }
            else {
                pivot = (pivot + numList.length +1)/2;
            }

        }
    }

    public int[] bubble(int[] list, boolean ascending) {

    }
}