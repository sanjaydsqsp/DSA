//Heap: MinHeap Insert
//Implement the insert method in the MinHeap class.
//
//The MinHeap class represents a min heap, a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
//
//The Heap class currently has several helper methods:
//
//getHeap that returns a new list containing all elements of the heap,
//
//leftChild that returns the index of the left child of a node at a given index,
//
//rightChild that returns the index of the right child of a node at a given index,
//
//parent that returns the index of the parent of a node at a given index,
//
//swap that swaps the elements at two given indices in the heap.
//
//
//
//The insert method should add a new integer value to the heap while maintaining the min heap property. In other words, after insertion, each parent node (including the newly inserted element) should be less than or equal to its child nodes.
//
//The insert method should work as follows:
//
//Add the new value to the end of the heap (the next available position in the complete binary tree).
//
//Compare the inserted element with its parent. If the inserted element is less than its parent, then swap the element with its parent.
//
//Continue this process until the min heap property is restored (i.e., the parent is less than its children).
//
//
//
//Utilize the parent and swap helper methods in your implementation.



///Heap: MinHeap Remove
//You have been provided with a MinHeap class that includes the sinkDown method.
//
//** We will be writing the sinkDown method in the next exercise so please do not peek at it in this exercise.  ;-)
//
//Implement the remove method of the MinHeap class.
//
//The MinHeap class represents a min heap, which means every parent node is always less than or equal to its child nodes.
//
//The Heap class contains several methods already:
//
//getHeap that returns the underlying list representation of the heap,
//
//leftChild that returns the index of the left child of a given index,
//
//rightChild that returns the index of the right child of a given index,
//
//parent that returns the index of the parent of a given index,
//
//swap that swaps the elements of the heap at two given indices,
//
//insert that inserts a value into the heap while maintaining the min heap property,
//
//sinkDown that ensures the min heap property by moving an element at a given index down the heap until it is less than its children.
//
//
//
//You are to implement the remove method which is responsible for removing the root element (the minimum element in the case of a min heap) from the heap and maintaining the heap property. In other words, after removal, the heap should still hold the min heap property for all elements.
//
//The remove method should perform the following steps:
//
//If the heap is empty, it should return null.
//
//If the heap only has one element, it should remove and return this element.
//
//In the case of a heap with more than one element, it should move the last element to the index of 0 then "sink down" the new root element until it is smaller than or equal to its children.
//
//
//
//Make use of the swap and sinkDown methods in your implementation.
//
//Consider edge cases such as when the heap is empty or has only one element when implementing this method.
//
//After you implement the remove method, the Heap class should provide a full implementation of a min heap data structure. Validate your solution by inserting several elements, removing them, and verifying the min heap property is preserved.




//Heap: MinHeap Sink Down
//Implement the sinkDown(int index) method.
//
//The MinHeap class represents a min heap, a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
//
//The MinHeap class currently provides several helper methods:
//
//getHeap() returns a new list containing all elements of the heap,
//
//leftChild(int index) returns the index of the left child of a node at a given index,
//
//rightChild(int index) returns the index of the right child of a node at a given index,
//
//parent(int index) returns the index of the parent of a node at a given index,
//
//swap(int index1, int index2) swaps the elements at two given indices in the heap.
//
//
//
//The sinkDown(int index) method should take an integer index as a parameter and restore the min heap property when it is violated by the node at the input index. This can happen when a node's value becomes greater than one or both of its children's values, often after a removal operation in a heap.
//
//The sinkDown(int index) method should perform as follows:
//
//Calculate the indices of the left and right children of the node at the input index using the leftChild(int index) and rightChild(int index) methods.
//
//Identify the minimum value among the node and its children.
//
//If the minimum value is not at the input index, swap the node at the input index with the node containing the minimum value.
//
//Continue this process for the swapped child node until the node is either a leaf node or its value is less than both its children.
//
//
//
//Your implementation should ensure that after calling the sinkDown(int index) method, the min heap property holds, i.e., the value of each node is less than or equal to the values of its children. Remember to use the provided helper methods to assist in your implementation.


package com.dsa.demo.Heap;
import java.util.ArrayList;
import java.util.List;
public class MinHeap {

        private List<Integer> heap;

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        public List<Integer> getHeap() {
            return new ArrayList<>(heap);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private void swap(int index1, int index2) {
            int temp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, temp);
        }

        public void insert(int value){

            heap.add(value);

            int current=heap.size()-1;
            while(current>0 && heap.get(current)<heap.get(parent(current))){
                swap(current,parent(current));
                current=parent(current);

            }

        }
    public void sinkDown(int index){
        int minIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }
    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return minValue;
    }


}


