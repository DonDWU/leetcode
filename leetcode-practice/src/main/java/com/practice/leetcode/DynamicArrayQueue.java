package com.practice.leetcode;

public class DynamicArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String data) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }

        items[tail] = data;
        tail++;

        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
