package com.company;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] mas = {1, 2,-1, 4, 6, 12, 160, 52};
        System.out.println(binarySearch(mas, 4));
        System.out.println(binarySearchRecursion(mas, 4, 0, mas.length));
    }

    public static int binarySearch(int[] numList, int target) {
        Arrays.sort(numList);
        int upper = numList.length;
        int lower = 0;
        int pivot = (numList.length+1)/2;
        while (numList[pivot] != target) {
            if (numList[pivot] > target) {
                upper = pivot;
            }
            else {
                lower = pivot;
            }
            if (Math.abs(lower-upper)<2 && lower != target && upper != target) {
                return -1;
            }
            pivot = (upper+lower)/2;
        }
        return pivot;
    }

    public static int binarySearchRecursion(int[] numList, int target, int start, int end) {
        Arrays.sort(numList);
        int pivot = (start+end)/2;
        if (numList[pivot] > target) {
            return binarySearchRecursion(numList, target, start, pivot);
        }
        else if (numList[pivot] < target) {
            return binarySearchRecursion(numList, target, pivot, end);
        }
        else if (numList[pivot] == target) return pivot;
        return -1;
    }

//    public int[] bubble(int[] list, boolean ascending) {
//
//    }
}