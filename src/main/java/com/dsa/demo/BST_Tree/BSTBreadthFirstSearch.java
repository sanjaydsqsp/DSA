
///BST: Breadth First Search (BFS)
//Create a BFS method within a BinaryTree class that performs a breadth-first search traversal of the tree and returns an ArrayList of the visited nodes' values in the order they were visited.
//
//Return type:  ArrayList<Integer>
//
//
//
//The method should perform the following tasks:
//
//Initialize currentNode as the root of the tree.
//
//Create a queue of Node objects named queue using a LinkedList.
//
//Create an ArrayList of Integers named results to store the visited nodes' values.
//
//Add the currentNode to the queue.
//
//Use a while loop to iterate until the queue is empty: a. Remove the first element from the queue and set currentNode to the removed element. b. Add the value of currentNode to the results ArrayList. c. If currentNode has a left child, add it to the queue. d. If currentNode has a right child, add it to the queue.
//
//Return the results ArrayList.
package com.dsa.demo.BST_Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class BSTBreadthFirstSearch {





        public Node root;

        public static class Node {
            public int value;
            public Node left;
            public Node right;

            private Node(int value) {
                this.value = value;
            }
        }

        public Node getRoot() {
            return root;
        }

        public boolean insert(int value) {
            Node newNode = new Node(value);
            if (root == null) {
                root = newNode;
                return true;
            }
            Node temp = root;
            while (true) {
                if (newNode.value == temp.value) return false;
                if (newNode.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }

        public boolean contains(int value) {
            if (root == null) return false;
            Node temp = root;
            while (temp != null) {
                if (value < temp.value) {
                    temp = temp.left;
                } else if (value > temp.value) {
                    temp = temp.right;
                } else {
                    return true;
                }
            }
            return false;
        }


        public ArrayList<Integer> BFS(){
            Queue<Node> queue=new LinkedList();
            ArrayList<Integer> values=new ArrayList();

            queue.add(root);

            while(queue.size()>0){
                Node currentNode=queue.remove();
                values.add(currentNode.value);
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);

            }
            return values;
        }

    }
