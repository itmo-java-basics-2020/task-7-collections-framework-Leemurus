package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final Map<Integer, Integer> map;
    private final Queue<Integer> queue;

    public FirstUnique(int[] numbers) throws IllegalArgumentException {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers array can't be null");
        }

        queue = new ArrayDeque<>();
        map = new HashMap<>();
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.element()) > 1) {
            queue.remove();
        }
        return (queue.isEmpty() ? -1 : queue.element());
    }

    public void add(int value) {
        queue.add(value);
        map.merge(value, 1, Integer::sum);
    }
}
