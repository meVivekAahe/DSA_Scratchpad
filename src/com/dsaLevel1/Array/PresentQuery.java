package com.dsaLevel1.Array;

import java.util.Scanner;

public class PresentQuery {
    public static  int[] makeFrequencyArr(int[] arr){
        int[] freqArr = new int[100005];
        for(int i = 0; i<arr.length;i++){
            freqArr[arr[i]]++;
        }
        return freqArr;
    }

    public static void main(String[] args) {
        int [] arr = {10,34,84,91,834,1101};
        int [] freqArr = makeFrequencyArr(arr);
        System.out.println("enter the number of queries : ");
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q > 0){
            System.out.println("enter the number to be searched : ");
            int x = sc.nextInt();
            if(freqArr[x] > 0){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            q--;
        }
    }

    }

