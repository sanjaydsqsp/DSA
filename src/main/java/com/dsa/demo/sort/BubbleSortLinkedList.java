//Bubble Sort of LL ( ** Interview Question)
//Implement the bubble sort algorithm in a singly linked list.
//
//The linked list will contain integer elements.
//
//You need to write a method bubbleSort() within the LinkedList class. This method will sort the linked list in ascending order using the Bubble Sort algorithm.
//
//The Bubble Sort algorithm works by comparing each pair of adjacent elements in the list and swapping them if they are in the wrong order. The pass through the list is repeated until the list is sorted.
//
//Here is a brief overview of the steps involved in implementing the bubble sort algorithm:
//
//Check if the length of the linked list is less than 2. If it is, the list is already sorted, so the method should return immediately.
//
//Initialize a Node object sortedUntil to null. This will act as a marker to the end of the sorted portion of the list.
//
//Set up a while loop that continues as long as sortedUntil does not equal the second node in the list (this.head.next).
//
//Within this loop, start from the head of the list and compare the value of the current node with the value of the next node.
//
//If the value of the current node is greater than the value of the next node, swap the values.
//
//Continue comparing and swapping until you reach the node before sortedUntil.
//
//At the end of each pass through the list, set sortedUntil to the last node that was examined. This marks the end of the sorted portion of the list and the start of the unsorted portion for the next pass.
//
//The algorithm continues until the list is fully sorted.
//
//
//
//Please make sure your code follows the above steps to implement the bubble sort method correctly.
//
//You may assume that all values in the list are integers. Also, please note that your bubbleSort() method should not return any value; it should sort the linked list in-place. That is, it should modify the original linked list rather than creating and returning a new, sorted list.
package com.dsa.demo.sort;

public class BubbleSortLinkedList {

        private Node head;
        private Node tail;
        private int length;

        class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        public BubbleSortLinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public int getLength() {
            return length;
        }

        public void makeEmpty() {
            head = null;
            tail = null;
            length = 0;
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void append(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }


        public void bubbleSort(){

            if(this.length<2) return;

            Node sortedUntil=null;
            while(sortedUntil!=this.head.next){
                Node current=this.head;
                while(current.next!=sortedUntil){
                    Node newNode=current.next;
                    if(current.value>newNode.value){
                        int temp=current.value;
                        current.value=newNode.value;
                        newNode.value=temp;
                    }
                    current=current.next;
                }
                sortedUntil=current;
            }

        }
    }