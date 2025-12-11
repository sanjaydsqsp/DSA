//Bubble Sort
//Implement the bubbleSort method that sorts an input integer array using the Bubble Sort algorithm.
//
//Return type: void
//
//
//
//The method should perform the following tasks:
//
//Iterate through the input array from the last index to the first index (excluding the first index).
//
//For each index i, iterate through the array from the first index up to index i-1 (inclusive).
//
//Compare the element at the current index j with the element at the next index j+1.
//
//If the element at index j is greater than the element at index j+1, swap the two elements.
//
//After all iterations, the input array will be sorted in ascending order.

package com.dsa.demo.sort;
import java.util.Arrays;

public class bubbleSort {


        public static void bubbleSort(int []myArray){
            for(int i=myArray.length-1;i>0;i--){
                for(int j=0;j<i;j++){
                    if(myArray[j]>myArray[j+1]){
                        int temp=myArray[j];
                        myArray[j]=myArray[j+1];
                        myArray[j+1]=temp;
                    }
                }
            }
        }


        public static void main(String[] args) {

            int[] myArray = {4,2,6,5,1,3};

            bubbleSort(myArray);

            System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

        }

    }
