//BST: DFS InOrder
//Create a DFSInOrder method within a BinaryTree class that performs a depth-first search (in-order traversal) of the tree and returns an ArrayList of the visited nodes' values in the order they were visited.
//
//Return type: ArrayList<Integer>
//
//
//
//The method should perform the following tasks:
//
//Create an ArrayList of Integers named results to store the visited nodes' values.
//
//Define an inner class called Traverse that takes a Node called currentNode as a parameter:
//
//If currentNode has a left child, create a new Traverse object with the left child as the argument.
//
//Add the value of currentNode to the results ArrayList.
//
//If currentNode has a right child, create a new Traverse object with the right child as the argument.
//
//Create a new Traverse object with the root of the tree as the argument.
//
//Return the results ArrayList.
//
//
//
//I have also provided an alternative solution in the "Solution Explanation" section that employs a separate recursive helper method rather than using an inner class.
package com.dsa.demo.BST_Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class DFS_InOrder {



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

        public ArrayList<Integer> BFS() {
            Node currentNode = root;
            Queue<Node> queue = new LinkedList<>();
            ArrayList<Integer> results = new ArrayList<>();
            queue.add(currentNode);

            while (queue.size() > 0) {
                currentNode = queue.remove();
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            return results;
        }

        public ArrayList<Integer> DFSPreOrder() {
            ArrayList<Integer> results = new ArrayList<>();

            class Traverse {
                Traverse(Node currentNode) {
                    results.add(currentNode.value);
                    if (currentNode.left != null) {
                        new Traverse(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        new Traverse(currentNode.right);
                    }
                }
            }

            new Traverse(root);
            return results;
        }

        public ArrayList<Integer> DFSPostOrder() {
            ArrayList<Integer> results = new ArrayList<>();

            class Traverse {
                Traverse(Node currentNode) {
                    if (currentNode.left != null) {
                        new Traverse(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        new Traverse(currentNode.right);
                    }
                    results.add(currentNode.value);
                }
            }

            new Traverse(root);
            return results;
        }

        public ArrayList<Integer> DFSInOrder(){
            return traverse(root);
        }

        private ArrayList<Integer> traverse(Node node){
            ArrayList<Integer> res=new ArrayList();

            if(node.left!=null)
                res.addAll(traverse(node.left));
            res.add(node.value);
            if(node.right!=null)
                res.addAll(traverse(node.right));


            return res;
        }
        // WRITE DFS_INORDER METHOD HERE //
        //                               //
        //                               //
        //                               //
        //                               //
        ///////////////////////////////////

    }
