
//Array: Remove Element ( ** Interview Question)
//Problem Description
//
//You are given an integer array nums and an integer val.
//
//Your task is to:
//
//Remove all occurrences of val from nums in-place.
//
//Return the new length k of the array after removal.
//
//The removal must be done without using extra arrays.
//
//After you return k:
//
//The first k elements of nums should contain the values that are not equal to val.
//
//The order of these k elements does not matter.
//
//Anything stored in nums after index k - 1 can be ignored and is not checked.
//
//You only need to ensure:
//
//k is correct.
//
//The first k positions contain elements not equal to val.
//
//Method Signature
//
//public static int removeElement(int[] nums, int val)
//Example 1
//
//Input
//
//nums = [3, 2, 2, 3], val = 3
//
//Valid output:
//
//New length: k = 2
//
//First k elements: [2, 2]
//
//The array in memory might look like [2, 2, 2, 3] or [2, 2, 3, 3] afterward.
//Both are fine because only the first 2 elements matter.
//
//Example 2
//
//Input
//
//nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4], val = 1
//
//Elements equal to 1 should be removed.
//
//One valid result:
//
//New length: k = 7
//
//First k elements: [-2, -3, 4, -1, 2, -5, 4]
//
//The array might look like:
//
//[-2, -3, 4, -1, 2, -5, 4, -5, 4]
//
//Here:
//
//First 7 elements are all not equal to 1.
//
//The last 2 elements are ignored.
//
//How it works (conceptual)
//
//You can solve this with a write index:
//
//Scan nums from left to right.
//
//Each time you see a value not equal to val, write it at the current write position and move the write position forward.
//
//At the end, the write position is your k.
//
//This keeps everything in-place and only cares about the first k elements.



package com.dsa.demo.arrays;

import java.util.*;


public class ArrayRemoveElement {

    public static int removeElement(int[] nums, int val){
        return Arrays.stream(nums).mapToObj(p->(int)p).filter(p->p!=val).toArray().length;
    }




    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                           "\nNew length: " + newLength1);
                           
        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int val2 = 6;
        int newLength2 = removeElement(nums2, val2);
        System.out.println("Test case 2: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
                           "\nNew length: " + newLength2);
                           
        // Test case 3
        int[] nums3 = {-1, -2, -3, -4, -5};
        int val3 = -1;
        int newLength3 = removeElement(nums3, val3);
        System.out.println("Test case 3: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
                           "\nNew length: " + newLength3);
    
        // Test case 4
        int[] nums4 = {};
        int val4 = 1;
        int newLength4 = removeElement(nums4, val4);
        System.out.println("Test case 4: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
                           "\nNew length: " + newLength4);
    
        // Test case 5
        int[] nums5 = {1, 1, 1, 1, 1};
        int val5 = 1;
        int newLength5 = removeElement(nums5, val5);
        System.out.println("Test case 5: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
                           "\nNew length: " + newLength5);
    }

}


