package com.company;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] temp = s.toCharArray();
        char[] result = new char[s.length()];

        for (int i = 0; i<s.length(); i++) {
            result[s.length()-i-1] = temp[i];
        }
        String output = new String(result);
        System.out.println(output);

    }
}
