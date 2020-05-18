package ru.ifmo.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final Queue<Integer> min_heap;

    public KthLargest(int k, int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array can't be null or empty");
        }

        min_heap = new PriorityQueue<>();
        for (int number : numbers) {
            min_heap.add(number);
        }

        while (min_heap.size() != k) {
            min_heap.remove();
        }
    }

    public int add(int val) {
        if (val > min_heap.element()) {
            min_heap.remove();
            min_heap.add(val);
        }
        return min_heap.element();
    }
}