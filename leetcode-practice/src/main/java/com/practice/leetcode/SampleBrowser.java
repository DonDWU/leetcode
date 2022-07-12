package com.practice.leetcode;

public class SampleBrowser {

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url) {
        if (this.currentPage != null) {
            this.backStack.push(currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + "page == " + url);
    }

    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");

            return forwardUrl;
        }
        System.out.println("* can not go forward, no page forward.");
        return null;
    }

    public String goBack() {
        if (this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("* can not go back, no page behind.");
        return null;
    }

    public boolean canGoBack() {
        return this.backStack.size > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size > 0;
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + currentPage);
    }

    public static class LinkedListBasedStack {

        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        public String pop() {
            Node popNode = this.top;
            if (popNode == null) {
                System.out.println("Stack is empty.");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0) {
                this.size--;
            }

            return popNode.data;
        }

        public String getTopData() {
            return this.top.data;
        }

        public int size() {
            return this.size;
        }

        public void clear() {
            this.size = 0;
            this.top = null;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Node getTop() {
            return top;
        }

        public void setTop(Node top) {
            this.top = top;
        }

        public static class Node {
            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
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
}
