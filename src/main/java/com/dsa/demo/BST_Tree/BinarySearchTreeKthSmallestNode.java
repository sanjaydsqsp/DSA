//BST: Kth Smallest Node ( ** Interview Question)
//The kthSmallest(int k) method should find the kth smallest element in the binary search tree. If such an element exists, the method should return its value. If not, it should return null. The smallest element in the tree is the one with the lowest value, the second smallest element is the one with the second lowest value, and so on.
//
//The method should use the in-order traversal technique to visit the nodes of the tree, i.e., it should first visit the left child, then the parent, and finally the right child. To implement this, use a Stack<Node> to store the nodes. Continue with the traversal as long as there are nodes in the stack or the current node is not null.
//
//While the current node is not null, push it onto the stack and move to its left child. Then, once the current node is null, pop a node from the stack, decrement k by one, and if k is zero, return the value of the popped node. Finally, move to the right child of the popped node.
//
//Examples
//
//For example, if the binary search tree contains the elements [5, 3, 7, 2, 4, 6, 8] and k is 1, the method should return 2 as this is the smallest element. If k is 3, it should return 4, the third smallest element. If k is 6, it should return 7, the sixth smallest element. If k is greater than the number of elements in the tree, the method should return null.
//
//Constraints
//
//You can assume the following constraints:
//
//The value of k will be a positive integer, not exceeding the number of elements in the tree.
//
//The insert(int value) method will be called at least once before kthSmallest(int k).
package com.dsa.demo.BST_Tree;

import java.util.*;

public class BinarySearchTreeKthSmallestNode {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
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
    
    public Integer kthSmallest(int k){
        
        ArrayList<Integer> data=traverse(root);
        if(k<1 || k>data.size()) return null;
        
        return data.get(k-1);
        
    }
    
    private ArrayList<Integer> traverse(Node node){
        ArrayList<Integer> data=new ArrayList();
        if(node==null) return null;
        
        if(node.left!=null){
            data.addAll(traverse(node.left));
        }
        
        data.add(node.value);
        
        if(node.right!=null){
            data.addAll(traverse(node.right));
        }
        
        return data;
    }
    
}
