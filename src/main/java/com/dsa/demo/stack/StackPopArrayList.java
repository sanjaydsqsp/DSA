///Stack: Pop for a Stack That Uses an ArrayList ( ** Interview Question)
//Add a method to pop a value from the Stack implementation that we began in the last Coding Exercise.
//
//Return type: T
//
//Remember: This Stack implementation uses an ArrayList instead of a Linked List.


package com.dsa.demo.stack;
import java.util.ArrayList;
public class StackPopArrayList <T> {





        private ArrayList<T> stackList = new ArrayList<>();

        public ArrayList<T> getStackList() {
            return stackList;
        }

        public void printStack() {
            for (int i = stackList.size()-1; i >= 0; i--) {
                System.out.println(stackList.get(i));
            }
        }

        public boolean isEmpty() {
            return stackList.size() == 0;
        }

        public T peek() {
            if (isEmpty()) {
                return null;
            } else {
                return stackList.get(stackList.size() - 1);
            }
        }

        public int size() {
            return stackList.size();
        }

        public void push(T value) {
            stackList.add(value);
        }


        public T pop(){
            if(stackList.size()==0) return null;
            return stackList.remove(stackList.size()-1);
        }

}
