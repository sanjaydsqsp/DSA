///HT: First Non-Repeating Character ( ** Interview Question)
//You have been given a string of lowercase letters.
//
//Write a function called firstNonRepeatingChar(String) that finds the first non-repeating character in the given string using a hash table (HashMap). If there is no non-repeating character in the string, the function should return null.
//
//For example, if the input string is "leetcode", the function should return "l" because "l" is the first character that appears only once in the string. Similarly, if the input string is "hello", the function should return "h" because "h" is the first non-repeating character in the string.
//
//Return type: Character


package com.dsa.demo.hashTable;
import java.util.*;
public class HashTableFirstNonRepeatingChar {




        public static Character firstNonRepeatingChar(String str){
            HashMap<Character,Integer> chars=new HashMap();
            for(int i=0;i<str.length();i++){
                chars.put(str.charAt(i),chars.getOrDefault(str.charAt(i),0)+1);
            }

            for(char ch:chars.keySet()){
                if (chars.get(ch)==1) return ch;
            }
            return null;
        }

        public static void main(String[] args) {
            System.out.println(firstNonRepeatingChar("leetcode"));
            System.out.println(firstNonRepeatingChar("hello"));
            System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

        }

    }

