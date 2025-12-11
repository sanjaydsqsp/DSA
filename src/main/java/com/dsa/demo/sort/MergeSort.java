//Merge Sort
//Implement the mergeSort method that takes an unsorted integer array as input and returns a new array containing all the elements from the input array, sorted in ascending order using the merge sort algorithm.
//
//Return type: int[]
//
//
//
//The method should perform the following tasks:
//
//Check if the length of the input array is 1; if so, return the array as it is already sorted.
//
//Calculate the middle index of the input array as midIndex.
//
//Recursively call the mergeSort method on the left half of the input array, starting from the first element up to the midIndex, and store the result in the left array.
//
//Recursively call the mergeSort method on the right half of the input array, starting from the midIndex to the end of the array, and store the result in the right array.
//
//Call the merge method, passing in the left and right arrays, to merge them into a single sorted array.
//
//Return the merged array containing all the elements from the input array, sorted in ascending order.
package com.dsa.demo.sort;
import java.util.Arrays;
public class MergeSort {





        public static int[] merge(int[] array1, int[] array2) {
            int[] combined = new int[array1.length + array2.length];
            int index = 0;
            int i = 0;
            int j = 0;
            while (i < array1.length && j < array2.length) {
                if (array1[i] < array2[j]) {
                    combined[index] = array1[i];
                    index++;
                    i++;
                } else {
                    combined[index] = array2[j];
                    index++;
                    j++;
                }
            }
            while (i < array1.length) {
                combined[index] = array1[i];
                index++;
                i++;
            }
            while (j < array2.length) {
                combined[index] = array2[j];
                index++;
                j++;
            }
            return combined;
        }


        public static int[]  mergeSort(int [] array){
            int midIndex=array.length/2;
            if(array.length==1)return array;
            int []left=mergeSort(Arrays.copyOfRange(array,0,midIndex));
            int []right=mergeSort(Arrays.copyOfRange(array,midIndex,array.length));

            return merge(left,right);
        }


        public static void main(String[] args) {

            int[] originalArray = {3,1,4,2};

            int [] sortedArray = mergeSort(originalArray);

            System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

            System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */

        }

    }

