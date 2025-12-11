//Selection Sort of LL ( ** Interview Question)
//Implement the Selection Sort algorithm on a singly linked list.
//
//The linked list will contain integer elements.
//
//You are required to write a method selectionSort() within the LinkedList class. This method will sort the linked list in ascending order using the Selection Sort algorithm.
//
//The Selection Sort algorithm works by dividing the list into a sorted and an unsorted region. The sorted region starts out empty and the unsorted region is initially the entire list. The algorithm repeatedly selects the smallest (or largest, depending on sorting order) element from the unsorted region and moves it into the sorted region. When the unsorted region becomes empty, the algorithm stops and the list is sorted.
//
//Here is a brief overview of the steps involved in implementing the selection sort algorithm:
//
//Check if the length of the linked list is less than 2. If it is, the list is already sorted, so the method should return immediately.
//
//Initialize a Node object current to the head of the list.
//
//Set up a while loop that continues as long as current.next is not null.
//
//Within this loop, set smallest to current and innerCurrent to the next node in the list.
//
//While innerCurrent is not null, if innerCurrent's value is less than smallest's value, set smallest to innerCurrent. Then, advance innerCurrent to the next node.
//
//After going through all nodes in the unsorted region, if smallest is not current, swap the values in smallest and current.
//
//Move current to the next node and repeat the process until the entire list is sorted.
//
//At the end of the sort, update the tail of the list to current.
//
//
//
//Please ensure your code follows these steps to correctly implement the selection sort method.
//
//Assume that all values in the list are integers. The selectionSort() method should not return any value; it should sort the linked list in-place. That is, it should modify the original linked list rather than creating and returning a new, sorted list.
package com.dsa.demo.sort;

public class SelectionSortLinkedList {


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

        public SelectionSortLinkedList(int value) {
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

        public void selectionSort(){
            if(length<2) return;

            Node current=this.head;
            while(current.next!=null){
                Node smallest=current;
                Node innerCurrent=current.next;
                while(innerCurrent!=null){
                    if(innerCurrent.value<smallest.value){
                        smallest=innerCurrent;
                    }
                    innerCurrent=innerCurrent.next;
                }
                if(smallest!=current){
                    int temp=smallest.value;
                    smallest.value=current.value;
                    current.value=temp;
                }
                current=current.next;
            }

        }

    }