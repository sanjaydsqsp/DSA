///Queue Using Stacks: Dequeue ( ** Interview Question)
//Implement the Dequeue Method for a Queue using Two Stacks
//
//Description:
//
//In this assignment, you are tasked with implementing the dequeue method for a
// custom queue class called MyQueue using two stacks, stack1 and stack2.
//
//A queue is a data structure that follows the First-In-First-Out (FIFO) principle,
// meaning that the first element added to the queue will be the first one to be removed.
//
//Your implementation must maintain the FIFO order of elements in the queue using two stacks.
//
//Your task is to implement the following method:
//
//
//
//public Integer dequeue()
//
//
//This method should remove and return the front element of the queue.
// If the queue is empty, the method should return null.
//
//Note: You are not allowed to use any data structures other than the provided stacks (stack1 and stack2).
//
//
//
//Guidelines:
//
//
//
//Check if the queue is empty using the isEmpty() method.
//
//If the queue is empty, return null.
//
//Otherwise, remove and return the front element of the queue by popping the top element from stack1.
//
//
//
//Example:
//
//
//
//MyQueue q = new MyQueue();
//q.enqueue(1);
//q.enqueue(2);
//q.enqueue(3);
//Integer front = q.dequeue(); // front should be 1, and the queue now has elements 2 and 3
//
//
//NOTE: I have added some diagrams under the Hints tab that show how this works, step-by-step.

package com.dsa.demo.queue;

import java.util.Stack;

public class DeQueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public DeQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }


   public Integer dequeue(){
       if(stack1.isEmpty()) return null;
       return stack1.pop();
   }


    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
    
}