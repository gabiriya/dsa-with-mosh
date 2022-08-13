package com.grados.exercice;

import java.util.Scanner;

public class FormtingExe {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 2; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.printf("%-15s%03d", s1,x);
//            System.out.printf("%3d",x);
        }
        System.out.println("================================");


    }
}
