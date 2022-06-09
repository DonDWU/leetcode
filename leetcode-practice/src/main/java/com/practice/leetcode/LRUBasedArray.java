package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = 1<<3;
    private int capacity;
    private int count;
    private T[] value;
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }
    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        holder = new HashMap<T, Integer>(capacity);
        count = 0;
    }

    /**
     * 访问某个值
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null");
        }

        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     */
    private void update(int index) {
        T target = value[index];
        rightShit(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * index 左边的数据统一右移一位
     */
    private void rightShit(int index) {
        for (int i = index - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i+1);
        }
    }

    /**
     * 缓存容器是否已满
     */
    private boolean isFull() {
        return count == capacity;
    }

    /**
     * 移除缓存中的最后一位，添加新元素至缓存第一位
     */
    private void removeAndCache(T e) {
        T key = value[--count];
        holder.remove(key);
        cache(e, count);
    }

    /**
     * 先右移元素，然后将新元素缓存至头部
     */
    private void cache(T e, int index) {
        rightShit(index);
        value[0] = e;
        holder.put(e, 0);
        count++;
    }
}
