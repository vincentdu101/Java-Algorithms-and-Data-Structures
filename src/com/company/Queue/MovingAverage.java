package com.company.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> data;
    private int size;
    private List<Integer> cache;
    private int start = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        // we need both a list and a queue to keep track of the queue
        // the queue has no way of iterating one element after another

        // that is what the list is for
        data = new LinkedList();
        cache = new ArrayList<>();
        this.size = size;
    }

    public double next(int val) {
        // notice how we do remove the element for a queue, but we
        // just add the start of the list further along and we
        // don't actually remove anything
        if (size < data.size() + 1) {
            data.poll();
            start++;
        }

        data.offer(val);
        cache.add(val);
        return calculateSum() / data.size();
    }

    private double calculateSum() {
        // iterate through the elements and calculate the sum
        double total = 0.0;
        int count = start;

        while (count < cache.size()) {
            double peek = cache.get(count);
            total += peek;
            count++;
        }
        return total;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */