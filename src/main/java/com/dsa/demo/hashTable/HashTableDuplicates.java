///HT: Find Duplicates ( ** Interview Question)
//findDuplicates()
//
//
//Problem: Given an array of integers nums, find all the duplicates in the array using a hash table (HashMap).
//
//
//Input:
//
//An array of integers nums.
//
//
//
//Return Type:
//
//List<Integer> implemented as an ArrayList
//
//List is an interface and ArrayList is a way of implementing the List interface
//
//For more information about interfaces click on "Hints".
//
//
//
//
//
//
//
//Input: int[] nums = [4, 3, 2, 7, 8, 2, 3, 1]
//Output: [2, 3]
//Explanation: The numbers 2 and 3 appear more than once in the input array.
//
//Input: int[] nums = [1, 2, 3, 4, 5]
//Output: []
//Explanation: There are no duplicates in the input array, so the function returns an empty list [].
//
//Input: int[] nums = [3, 3, 3, 3, 3]
//Output: [3]
//Explanation: The number 3 appears more than once in the input array.
//
//Input: int[] nums = [-1, 0, 1, 0, -1, -1, 2, 2]
//Output: [-1, 0, 2]
//Explanation: The numbers -1, 0, and 2 appear more than once in the input array.
//
//Input: int[] nums = []
//Output: []
//Explanation: There are no numbers in the input array, so the function returns an empty list [].

package com.dsa.demo.hashTable;
import java.util.*;
public class HashTableDuplicates {


        public static ArrayList<Integer> findDuplicates(int[] array){

            HashMap<Integer,Integer> map=new HashMap();
            //   TreeSet<Integer> duplicateList=new TreeSet();
            ArrayList<Integer> duplicateList=new ArrayList();
            for(int i:array){
                //   if(map.get(i)!=null) duplicateList.add(i);
                //   else map.put(i,true);

                if(map.get(i)!=null) map.put(i,map.get(i)+1);
                else map.put(i,1);
            }

            for(int key:map.keySet()){
                if(map.get(key)>1)
                    duplicateList.add(key);
            }
            return duplicateList;
        }



        public static void main(String[] args) {

            int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
            List<Integer> duplicates = findDuplicates(nums);
            System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

        }

    }

