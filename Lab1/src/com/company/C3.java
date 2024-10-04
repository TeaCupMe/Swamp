package com.company;
import java.util.Scanner;

public class C3 {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine();
        System.out.println(splitCamel(str));
    }

    public static String splitCamel(String input) {
        String output = "";

        int pointer = 0;
        for (int i = 0; i<input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                output = String.join(" ", output, input.substring(pointer, i));
                pointer = i;
            }
        }
        output = String.join(" ", output, input.substring(pointer, input.length()));
        return output.substring(1);
    }
}
