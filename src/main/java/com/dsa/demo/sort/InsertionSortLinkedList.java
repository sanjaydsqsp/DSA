//Insertion Sort of LL ( ** Interview Question)
//Write  insertionSort() method that sorts a singly linked list in ascending order using the Insertion Sort algorithm. The method should take no input arguments.
//
//The insertionSort() method should sort the linked list in place by repeatedly inserting each unsorted node into its correct position in the sorted part of the list.  If the length of the linked list is less than 2, the method should simply return because the list is already sorted.  After the sort, the method should update the head and tail pointers of the linked list to point to the first and last nodes, respectively.
//
//The implementation should start with a sortedListHead variable that initially points to the head of the list, and a unsortedListHead variable that initially points to the second node in the list (if it exists).  The method should then iterate through the unsorted part of the list and insert each node into its correct position in the sorted part of the list.
//
//If a node in the unsorted part of the list is less than the head of the sorted part of the list, it should become the new head of the sorted list. Otherwise, the method should iterate through the sorted part of the list using a searchPointer variable until it finds the correct position to insert the node.  The node should then be inserted into the sorted list by updating the next reference of the previous node to point to the new node, and the next reference of the new node to point to the next node in the sorted part of the list.
package com.dsa.demo.sort;

public class InsertionSortLinkedList {


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

        public InsertionSortLinkedList(int value) {
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

        public void insertionSort(){
            if(length<2) return;

            Node sorted=head;
            Node unsorted=head.next;

            while(unsorted!=null){

                while(sorted!=unsorted){
                    if(unsorted.value<sorted.value){
                        int temp=unsorted.value;
                        unsorted.value=sorted.value;
                        sorted.value=temp;
                    }
                    sorted=sorted.next;


                }
                sorted=head;
                unsorted=unsorted.next;

            }

        }

    }