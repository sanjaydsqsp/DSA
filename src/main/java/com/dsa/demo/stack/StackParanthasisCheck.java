///Stack: Parentheses Balanced ( ** Interview Question)
//Check to see if a string of parentheses is balanced or not.
//
//By "balanced," we mean that for every open parenthesis,
// there is a matching closing parenthesis in the correct order.
// For example, the string "((()))" has three pairs of balanced parentheses,
// so it is a balanced string. On the other hand, the string "(()))" has an imbalance,
// as the last two parentheses do not match, so it is not balanced.  Also,
// the string ")(" is not balanced because the close parenthesis needs to follow
// the open parenthesis.
//
//
//Your program should take a string of parentheses as input and return true
// if it is balanced, or false if it is not.  In order to solve this problem,
// use a Stack data structure.
//
//Method name: isBalancedParentheses
//
//Return type: boolean
//
//This method will be written in the same class as the main method so it will be static.
// For more information on static methods click on "Hints."
//
//This will use the Stack class we created in these coding exercises:

package com.dsa.demo.stack;

import  java.util.Stack;
public class StackParanthasisCheck {

        public static boolean  isBalancedParentheses(String testStr){


            Stack<Character> stack=new Stack<>();

            for(char p:testStr.toCharArray()){
                if(p =='('){
                    stack.push(p);

                }else if(p== ')'){
                    if(stack.isEmpty() || stack.pop() != '('){

                        return false;
                    }
                }
            }

            return stack.isEmpty();

        }



        public static void main(String[] args) {
            testAndPrint("()", true);
            testAndPrint("()()", true);
            testAndPrint("(())", true);
            testAndPrint("()()()", true);
            testAndPrint("(()())", true);
            testAndPrint(")()(", false);
            testAndPrint(")(", false);
            testAndPrint("(()", false);
            testAndPrint("))", false);
            testAndPrint("(", false);
            testAndPrint(")", false);
        }

        public static void testAndPrint(String testStr, boolean expected) {
            // Run the test and store the result
            boolean result = isBalancedParentheses(testStr);

            // Print the test string, expected result, and actual result
            System.out.println("Test String: " + testStr);
            System.out.println("EXPECTED: " + expected);
            System.out.println("RESULT: " + result);

            // Check if the test passed or failed
            if (result == expected) {
                System.out.println("STATUS: PASS");
            } else {
                System.out.println("STATUS: FAIL");
            }

            // Print a separator for better readability
            System.out.println("--------------");

    }

}
