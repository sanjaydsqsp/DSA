//Insertion Sort
//Implement the insertionSort method that sorts an input integer array using the Insertion Sort algorithm.
//
//Return type: void
//
//
//
//The method should perform the following tasks:
//
//Iterate through the input array from the second index to the last index (inclusive).
//
//Store the element at the current index i in a temporary variable temp.
//
//Initialize a new index variable j as i - 1.
//
//Run a while loop as long as j is greater than or equal to 0, and the element at index j is greater than temp.
//
//Shift the element at index j to the right by one position (assign it to index j+1).
//
//Update the element at index j with the value of temp.
//
//Decrement j.
//
//After all iterations, the input array will be sorted in ascending order.
package com.dsa.demo.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int [] myArray){

        for (int i = 1; i < myArray.length; i++) {
            int temp = myArray[i];
            for( int j = i - 1;(j > -1 && temp < myArray[j]);j--) {
                myArray[j+1] = myArray[j];
                myArray[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
