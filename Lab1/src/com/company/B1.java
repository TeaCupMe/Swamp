package com.company;

import java.util.Scanner;

public class B1 {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int[] arr = getArray();
        outputArray(changeArray(arr));
    }

    public static int[] changeArray(int[] array) {
        int b = array.length-1;
        int f = 0;
        while (f < b) {
            while (even(array[f]) && f != b) {
                f++;
            }
            while (!even(array[b]) && f != b) {
                b--;
            }
            int temp = array[b];
            array[b] = array[f];
            array[f] = temp;
        }
        return array;
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

    public static void outputArray(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void outputArray(boolean[] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static boolean even(int n) {
        return n%2==0;
    }
}
