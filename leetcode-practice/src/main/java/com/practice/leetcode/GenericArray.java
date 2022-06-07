package com.practice.leetcode;

public class GenericArray<T> {
    /**
     * 数据
     */
    private T[] data;
    /**
     * 已用空间
     */
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(0);
    }

    /**
     * 获取容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     */
    public int count() {
        return size;
    }

    /**
     * 当前数组是否为空
     * @return true-是；false-否
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 该下标在数组下标范围之内
     * @param index
     */
    public void checkIndex(int index) {
        if (index < 0 || index >= getCapacity()) {
            throw new IllegalArgumentException("Illegal index value!");
        }
    }

    /**
     * 设置数组指定位置上的值
     * @param index
     * @param e
     * @return
     */
    public int set(int index, T e) {
        checkIndex(index);
        data[index] = e;
        return index;
    }

    /**
     * 获取指定位置上的数据
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        for (T t : data) {
            if (t.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找指定元素的下标位置
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在指定位置插入元素
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的两倍
        if (size == getCapacity()) {
            resize(2 * data.length);
        }

        for (int i = size -1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 插入前校验
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组下标不符合要求");
        }
    }

    private void resize(int capacity) {
        T[] newData =(T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
