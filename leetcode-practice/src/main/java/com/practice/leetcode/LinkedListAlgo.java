package com.practice.leetcode;

/**
 * 单链表的操作
 */
public class LinkedListAlgo {

    /**
     * 单链表的反转
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node curr = list;
        Node pre = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     * 检测单链表的环
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }
    }

    public static class ListNode {
        private int value;
        private ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode solider = new ListNode(0);
        ListNode p = solider;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }

        return solider.next;
    }
}
