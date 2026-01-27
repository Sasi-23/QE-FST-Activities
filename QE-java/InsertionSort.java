package com.example;

public class InsertionSort {
    public static void main(String[] args){
        int[] numbers = {4,3,2,10,12,1,5,6};
        for (int i=1;i<numbers.length;i++)
            {
            int current = numbers[i];
            int j=i-1;
            while(j>=0 && numbers[j]> current){
                numbers[j+1] = numbers[j];
                j--;
            }
            numbers[j+1] = current;
        }
        System.out.println("Sorted Array:");
        for(int num:numbers){
            System.out.println(num + " ");
        }
    }
        }
