package com.practice.leetcode;

public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    /**
     * 头插法
     * @param value
     */
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }
    public void insertToHead(Node node) {
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    /**
     * 尾插法
     * @param value
     */
    public void insertToTail(int value) {
        Node node = new Node(value, null);

        if (head == null) {
            head = node;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }
    }

    public void insertAfter(Node node, int value) {
        Node newNode = new Node(value, null);
        insertAfter(node, newNode);
    }

    private void insertAfter(Node position, Node newNode) {
        if (position == null) {
            return;
        }
        newNode.next = position.next;
        position.next = newNode;
    }

    public void insertBefore(Node position, int value) {
        Node newNode = new Node(value, null);
        insertBefore(position, newNode);
    }

    private void insertBefore(Node position, Node newNode) {
        if (position == null) {
            return;
        }

        if (head == position) {
            newNode.next = head.next;
            head.next = newNode;
            return;
        }

        Node cursor = head;
        while (position != cursor.next) {
            cursor = cursor.next;
        }
        newNode.next = position;
        cursor.next = newNode;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
