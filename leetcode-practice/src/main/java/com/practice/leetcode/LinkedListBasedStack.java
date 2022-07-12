package com.practice.leetcode;

public class LinkedListBasedStack {
    private Node top;
    private int size;

    public void push(String data) {
        Node node = new Node(data);
        if (size == 0) {
            top = node;
        } else {
            Node next = top;
            top = node;
            top.next = next;
        }
        size++;
    }

    public String pop() {
        if (size == 0) {
            return null;
        } else {
            Node pop = top;
            top = top.next;
            size--;
            return pop.data;
        }
    }


    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this(data, null);
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
