package com.grados.exercice;

import java.util.Arrays;
import java.util.Scanner;

public class TwoTables {

    public static void main(String[] args) {
        int [] data1 = {1,2,3,4,5};
        int [] data2 = {11,22,33,44,55,66,77};
        int [] zero = {1,0,0,1,1,1,0,1,0,0,1,1,0,1,1,0,1,1};
//        remplir(data);
//        Tab_Fusion_2(data1,data2);
//        F2beta(data1,data2);
//        faceSo(data1,data2);
//        System.out.println(verifier(zero,21));
//        equilibrer(zero,18);

//        remplir2(data1);
        for ( ; ; ) System.out.println("hello world");
    }

    // 1
    static void  remplir(int [] table){
        Scanner scan = new Scanner(System.in);
        for (int i = 0 ; i < table.length ; i++){
            System.out.println("Saisir un nombre : ");
            table[i] = scan.nextInt();
        }
        scan.close();
        for (int i = 0 ; i< table.length ; i++){
            System.out.println(table[i]);
        }
    }

    // 2
    static void Tab_Fusion_1(int[] T,int[] S, int t,int s){
        int[] F1 = new int[t+s];
        for (int i=0; i< t ; i++){
            F1[i] = T[i];
        }

        int taille = t+s;

        int j = 0;
        for (int i = t ; i<taille; i++ ){
            F1[i] = S[j];
            j++;
        }

        for (int i = 0 ; i< t+s; i++){
            System.out.println(F1[i]);
        }
    }

    // 3
    static void Tab_Fusion_2(int[] T,int[] S){
        int[] F2 = new int[12];
        int m = 0, k = 0;
        if (T.length> S.length){
             m = S.length;
             k = 1;
        }else
            m = T.length;

        int j = 0;
//        int x = 0;
//        while (j<F2.length){
//            F2[x] = T[j];
//            j++;
//            x+=2;
//        }

        for (int n : T){
            F2[j] = n;
            j+=2;
        }
//        for (int i = 0 ; i<m*2 ; i+=2){
//            F2[i] = T[j];
//            j++;
//        }

        int l =0;
        int i ;
        for ( i = 1 ; i < j; i+=2){
            F2[i] = S[l];
            l++;
        }

        if (k == 1){
            for (int e = m ; e< T.length ; e++){
                F2[e] = T[e];
            }
        }else {
//            l = 0
            for (int e = i ; e< S.length+T.length ;e++){
                F2[e--] = S[l];
                l++;
            }
        }

        for (int e=0 ; e < 10;e++){
            System.out.println(F2[e]);
        }
    }

    static void F2beta(int[] T, int[] S){
        int[] F2 = new int[T.length+S.length];
        int i = 0 ,cnt=0;
        while (i<T.length || i<S.length){
            if (i<T.length) F2[cnt++] = T[i];
            if (i<S.length) F2[cnt++] = S[i++];
        }
        for (int it:F2) System.out.println(it);
    }

    static void faceSo(int[] T, int[] S) {
        int n1 = T.length;
        int n2 = S.length;
        int[] f = new int[n1+n2];
        int j= 0;
        int k = 0;
        for (int i=0 ; i< f.length ; i++){
            if (i%2==0 && j<T.length){
                f[i] = T[j];
                j++;
            }
            else if (i%2==0){
                f[i] = S[k];
                j++;
            }
            else if (k<n2){
                f[i] = S[k];
                k++;
            }
            else{
                f[i] = S[j];
                j++;
            }
        }
        for (int it: f) System.out.println(it);
    }

    static int verifier(int[] T, int n){
        int z= 0;
        int u = 0;
        for (int i : T){
            if (i == 0) z++;
            if (i == 1) u++;
        }
        if (z==u){
            System.out.println("Le tableau est equilibre:");
            return 0;
        }else {
            return (u - z);
        }
    }

    static int equilibrer(int []T , int n){
        int dif = verifier(T,n);
        int [] eq = new int[n+dif];
        System.arraycopy(T, 0, eq, 0, n);
        if ( dif== 0){
            return n;
        }
        if (dif>0){
            for (int i=n ; i<n+dif;i++){
                eq[i] = 0;
            }
        }else {
            for (int i=n ; i<n+dif;i++){
                eq[i] = 1;
            }
        }
        return eq.length;
    }

     static void remplir2(int [] t){

         Scanner sc = new Scanner(System.in);
         for (int i=0 ; i<t.length;i++){
             System.out.println("saisie un nombre:");
             int n = sc.nextInt();
             if (n != 0 && n != 1){
                 System.out.println("nombre invalid , veuillez ressayer");
                 i--;
             }else t[i] = n;
         }
         for (int i=0 ; i<t.length;i++){
             System.out.println(t[i]);
         }
    }
}
