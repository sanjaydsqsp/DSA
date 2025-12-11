//Quick Sort
//Pivot
//Implement the pivot method that takes an integer array, a pivotIndex, and an endIndex as input and rearranges the elements of the array around the pivot element, which is the element at the pivotIndex.
//
//The method should return the new pivot index after rearrangement.
//
//Return type: int
//
//
//
//The method should perform the following tasks:
//
//Initialize a swapIndex variable with the value of pivotIndex.
//
//Iterate through the array from pivotIndex + 1 to endIndex (inclusive) with an index i. a. If the element at index i is less than the pivot element (element at pivotIndex), increment the swapIndex, and then swap the elements at index i and swapIndex using a swap method.
//
//After iterating through the array, swap the pivot element with the element at swapIndex.
//
//Return the updated value of swapIndex after rearrangement.
//Create a quickSortHelper method within a sorting class that takes an integer array, a left index, and a right index as input and recursively sorts the array using the quick sort algorithm.
//
//Return type: void
//
//
//
//The method should perform the following tasks:
//
//Check if left is less than right; if not, return without performing any operation.
//
//Call the pivot method (described in a previous problem statement) with the array, left, and right as arguments to find the new pivot index after rearrangement.
//
//Recursively call quickSortHelper with the array, left, and the updated pivotIndex - 1 as arguments.
//
//Recursively call quickSortHelper with the array, the updated pivotIndex + 1, and right as arguments.

package com.dsa.demo.sort;
import java.util.Arrays;
public class QuickSort {





        private static void swap(int[] array, int firstIndex, int secondIndex) {
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        }

        private static int pivot(int[] array, int pivotIndex, int endIndex) {
            int swapIndex = pivotIndex;
            for (int i = pivotIndex + 1; i <= endIndex; i++) {
                if (array[i] < array[pivotIndex]) {
                    swapIndex++;
                    swap(array, swapIndex, i);
                }
            }
            swap(array, pivotIndex, swapIndex);

            return swapIndex;
        }



        public static void quickSortHelper(int []array,int left,int right){

            if(left<right){
                int pivotIndex=pivot(array,left,right);
                quickSortHelper(array,0,pivotIndex-1);
                quickSortHelper(array,pivotIndex+1,right);

            }

        }
        public static void quickSort(int[] array) {
            quickSortHelper(array, 0, array.length-1);
        }


        public static void main(String[] args) {

            int[] myArray = {4,6,1,7,3,2,5};

            quickSort(myArray);

            System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7]

         */

        }

    }

