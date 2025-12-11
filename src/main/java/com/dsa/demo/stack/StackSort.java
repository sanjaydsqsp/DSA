///Stack: Sort Stack ( ** Interview Question)
//The sortStack method takes a single argument, a Stack object.
// The method should sort the elements in the stack in ascending order
// (the lowest value will be at the top of the stack) using only one additional stack.
// The function should use the pop, push, peek, and isEmpty methods of the Stack object.
package com.dsa.demo.stack;

import java.util.Stack;
public class StackSort {


        public static void sortStack(Stack<Integer> stack) {
            Stack<Integer> additionalStack = new Stack<>();

            while (!stack.isEmpty()) {
                int temp = stack.pop();

                while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                    stack.push(additionalStack.pop());
                }

                additionalStack.push(temp);
            }

            while (!additionalStack.isEmpty()) {
                stack.push(additionalStack.pop());
            }
        }


        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(3);
            stack.push(1);
            stack.push(4);
            stack.push(2);

            System.out.println("Before sorting:");
            stack.stream().forEach(System.out::println);

            sortStack(stack);

            System.out.println("\nAfter sorting:");
            stack.stream().forEach(System.out::println);

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

        }




}
