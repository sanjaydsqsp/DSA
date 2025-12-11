///HT: Item In Common ( ** Interview Question)
//Write a function itemInCommon(array1, array2) that takes two arrays as input and returns true if there is at least one common item between the two lists, false otherwise.
//
//Use a HashMap to solve the problem that creates an O(n) time complexity.


package com.dsa.demo.hashTable;
import java.util.*;
public class HashTableCommonItems {




        public static boolean itemInCommon(int [] array1, int []array2){
            HashMap<Integer,Boolean> map=new HashMap();
            for(int i:array1){
                map.put(i,true);
            }

            for(int i:array2)
            {
                if(map.get(i)!=null) return true;
            }
            return false;
        }


        public static void main(String[] args) {

            int[] array1 = {1, 3, 5};
            int[] array2 = {2, 4, 5};

            System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

        }

    }
