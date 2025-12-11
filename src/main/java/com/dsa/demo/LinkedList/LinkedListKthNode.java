///LL: Find Kth Node From End ( ** Interview Question)
//Implement a method called findKthFromEnd that returns the k-th node from the end of a singly linked list.
//
//The linked list does not store its length, so you must determine the correct node without using a size property.
//
//The value of k is 1-based:
//
//k = 1 returns the last node (tail).
//
//k = 2 returns the second-to-last node.
//
//k = list length returns the head node.
//
//k <= 0 or k > list length returns null.
//
//You must solve this problem using the two-pointer technique, ensuring the solution runs in a single traversal of the list (O(n) time, O(1) space).
//
//
//
//
//
//Method Signature
//
//public Node findKthFromEnd(int k)
//
//
//
//
//Example
//
//LinkedList myList = new LinkedList(1);
//myList.append(2);
//myList.append(3);
//myList.append(4);
//myList.append(5);
//
//// The list is: 1 -> 2 -> 3 -> 4 -> 5
//
//Node result = myList.findKthFromEnd(2);
//// Returns the node with value 4 (2nd from the end)
//
//result = myList.findKthFromEnd(5);
//// Returns the node with value 1 (head, 5th from the end)
//
//result = myList.findKthFromEnd(6);
//// Returns null (list has only 5 nodes)
//
//result = myList.findKthFromEnd(0);
//// Returns null (k must be greater than 0)
//
//
//
//
//📘 What This Exercise Is Designed to Teach
//
//How to use the two-pointer (fast and slow) technique to solve linked list problems efficiently.
//
//How to handle edge cases in linked list traversal, such as:
//
//Empty lists
//
//k being 0 or negative
//
//k being larger than the list’s length
//
//How to traverse a linked list in one pass without calculating its length in advance.
//
//Reinforcing understanding of pointer movement and node referencing in singly linked lists.
package com.dsa.demo.LinkedList;
public class LinkedListKthNode {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListKthNode(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node findKthFromEnd(int k){

        Node fast=head;
        Node slow=head;
        if(head==null) return null;
        for (int i=0;i<k; i++ )
        {
            if(fast==null)
                return null;

            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    // WRITE FINDKTHFROMEND METHOD HERE //
    //                                  //
    //                                  //
    //                                  //
    //                                  //
    //////////////////////////////////////

}

