package com.dsaLevel1.Array;

import java.util.Arrays;

public class RotateArr {
    public static void swapWithoutTemp(int a , int b){
        a = a + b ;
        b = a - b;
        a = a - b;
    }

    public  static int[] reverseArray(int[] arr , int start ,int end){
        int temp  =0;
        //int len = arr.length; //int i = len-1 , j =0;
        while(start < end){
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++; end--;
        }
        //System.out.println(Arrays.toString(arr));
        return arr;
    }
    
    public static int[]  rotateArray(int[] arr , int k){
        int n = arr.length;
         k = k % n ; int j =0;
        int[] ans = new int[n];
        for(int i = n-k;i < n;i++){
            ans[j++] = arr[i];
        }
        for(int i= 0; i<n-k;i++){
            ans[j++] = arr[i];
        }
        return ans;
    } 
        //rotate the given array 'a' by 'k' steps ,  where 'k' is a non negetive number without using extra space
    public static void rotateInPlace(int[] arr , int k){
        int n = arr.length;
        reverseArray(arr ,0, n-k-1);
        reverseArray(arr,n-k , n-1);
        int[] newArr  =reverseArray(arr, 0, n-1);
        System.out.println(Arrays.toString(newArr));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //reverseArray(arr);
        /*String res= Arrays.toString(rotateArray(arr,5));
        System.out.println(res);*/

        rotateInPlace(arr,5);
    }
    
}
