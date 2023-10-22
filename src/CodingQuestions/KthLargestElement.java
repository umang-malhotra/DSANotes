package src.CodingQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Resource -> https://www.youtube.com/watch?v=HqPJF2L5h9U&ab_channel=AbdulBari
 * Note -> Look at the Time Complexity of heapify, insert, delete functions of a heap.
 * For implementation code of heap ask chatGPT following
 *
 * Write  code for a max heap creation in java [implemented in array] with following functions available
 *
 * insert(int val) -> insert node with value val in max heap
 * remove() -> Remove the max element from the heap.
 * createHeap(int[] array) -> create a max heap out of elements of array.
 *
 * These functions should use heapify process.
 *
 * Suggest time complexity of the functions as well.
 */

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0;i<nums.length;i++) {
            minHeap.add(nums[i]);
        }

        System.out.println("The iterator values are: ");
        while (k>1) {
            System.out.println(minHeap.poll());
            k--;
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        findKthLargest(new int[]{1, 2, 4, 7, 3}, 3);
    }
}
