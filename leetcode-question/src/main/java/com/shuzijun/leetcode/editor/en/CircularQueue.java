package com.shuzijun.leetcode.editor.en;

/**
 * @desc 循环队列，先进先出，队尾进，队首出
 */
public class CircularQueue {
    private String[] items;
    /**
     * 大小
     */
    private int n = 0;
    /**
     * 队首索引
     */
    private int head = 0;
    /**
     * 队尾索引
     */
    private int tail = 0;

    /**
     * 初始化一个固定大小的循环队列
     * @param capacity
     */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * 入队时在队尾插入数据，head索引不变，tail索引递增
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail +1) % n;
        return true;
    }

    /**
     * 出队
     * 出队时在队首取出数据，tail索引不变，head索引递增
     * @return
     */
    public String dequeue() {
        // 队列空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1)  % n;
        return ret;
    }
}
