package com.grados.edabit.arrays;

public class SumArray {

    public int sumArr(int[] arr){
        int sum = 0;
        int len = arr.length;

        if (len>1){
            sum += arr[len-1];
            int[] arr2 = new int[len-1];
            System.arraycopy(arr, 0, arr2, 0, len - 1);
//            sum += arr2[len-2];
            sumArr(arr2);
        }
        else
            sum += arr[0];
        System.out.println("the sum is : " + sum);
        return sum;
    }
}
