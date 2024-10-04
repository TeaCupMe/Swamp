package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int[] mas = getArray();
        int n = in.nextInt();
        Arrays.sort(mas);
        System.out.println(binarySearch(mas, n));
        System.out.println(binarySearchRecursion(mas, n, 0, mas.length));
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

        int pivot = (start+end)/2;
        if (numList[pivot] == target) return pivot;
        if (start > end) return -1;

        if (numList[pivot] > target) {
            return binarySearchRecursion(numList, target, start, pivot-1);
        }
        else {
            return binarySearchRecursion(numList, target, pivot+1, end);
        }
    }
    public static int[] getArray() {
        System.out.print("Input number of elements: ");
        int n = in.nextInt();
        System.out.print("Input elements: ");
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

//    public int[] bubble(int[] list, boolean ascending) {
//
//    }
}