//Selection Sort
//Implement the selectionSort method that sorts an input integer array using the Selection Sort algorithm.
//
//Return type: void
//
//
//
//The method should perform the following tasks:
//
//Iterate through the input array from the first index to the second last index (inclusive).
//
//Assume the current index i is the index of the minimum element.
//
//For each index i, iterate through the array from the index i+1 to the last index (inclusive).
//
//Compare the element at the current index j with the element at the assumed minimum index.
//
//If the element at index j is less than the element at the assumed minimum index, update the minimum index to j.
//
//After the inner loop, if the assumed minimum index is not equal to the current index i, swap the elements at the minimum index and the current index i.
//
//After all iterations, the input array will be sorted in ascending order.
package com.dsa.demo.sort;
import java.util.Arrays;
public class SelectionSort {





        public static void selectionSort(int [] myArray){
            for(int i=0;i<myArray.length;i++){
                int minIndex=i;

                for(int j=i+1;j<myArray.length;j++){
                    if(myArray[j]<myArray[minIndex]){
                        minIndex=j;
                    }
                }
                if(i!=minIndex){
                    int temp=myArray[i];
                    myArray[i]=myArray[minIndex];
                    myArray[minIndex]=temp;
                }
            }
        }

        public static void main(String[] args) {

            int[] myArray = {4,2,6,5,1,3};

            selectionSort(myArray);

            System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

        }

    }
