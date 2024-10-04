package com.company;

import java.util.Scanner;

public class C2 {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int[] bi_arr = getArray();
//        System.out.println(bi_arr[2]);
        int[] arr = convertBinaryArray(bi_arr);
//        outputArray(bi_arr);
        System.out.print("Decimal array: ");
        outputArray(arr);

        System.out.print("Input divisor: ");
        int n = in.nextInt();
        boolean output[] = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[i] = (arr[i] % n == 0) ? true : false;
        }
        outputArray(output);

    }

    public static int[] getArray() {
        System.out.print("Input number of elements: ");
        int n = in.nextInt();
        System.out.print("Input elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static int[] convertBinaryArray(int[] bi_arr) {
        int[] arr = new int[bi_arr.length];
        for (int i = 0; i < bi_arr.length; i++) {
            int element = 0;
            for (int j = 0; j <= i; j++) {
                element += bi_arr[j] == 1 ? Math.pow(2, (i - j)) : 0;
            }
            arr[i] = element;
        }
        return arr;
    }

    public static void outputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void outputArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}

StringBuilder, Buffer, StringPool
