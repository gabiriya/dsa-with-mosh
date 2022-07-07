package com.grados.mywork;

public class TheLinkedList {
    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);
        if (head == null) {
            head = tail = node;
            size++;
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        size++;
        current.next = tail = node;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (head == null) {
            size++;
            head = tail = node;
            return;
        }
        size++;
        node.next = head;
        head = node;
    }

    public int indexOf(int item) {
        int i = 0;
        var current = head;
        while (current != null) {
            if (current.value == item) {
                return i;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int item) {
        var current = head;
        while (current != null) {
            if (current.value == item)
                return true;
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if (head == null)
            return;
        size--;
        head = head.next;
    }

    public void removeLast() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        var current = head;
        while (current.next.next != null)
            current = current.next;
        size--;
        current.next = null;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        if (head == null)
            return;
        if (head == tail)
            return;
        var temp = head;
        head = tail;
        tail = temp;
        var current = head;
        while (current != null) {
            current.next = getPrevious(current);
            current = current.next;
        }

    }

    public int getKthFromTheEnd(int k) {
        if (k > size || k < 0) {
            throw new IllegalArgumentException();
        }
        if (head == tail)
            return head.value;
        var first = head;
        var second = head;
        for (int i = 0; i < k - 1; i++)
            second = second.next;

        while (second != tail) {
            first = first.next;
            second = second.next;
        }
        return first.value;
    }

    private Node getPrevious(Node node) {
        if (node == tail) {
            return null;
        }
        var current = tail;
        var previous = tail;
        while (current != null) {
            current = current.next;
            if (current == node)
                return previous;
            previous = previous.next;
        }
        return null;
    }


    public String getMiddle() {
        if (head == null)
            return "Error";
        var first = head;
        var second = head;
        while (true) {
            if (first.next == null) {
                return first.value + "";
            }
            if (second.next == null) {
                return "" + first.value;
            }
            if (second.next.next == null) {
                return "" + first.value + " - " + first.next.value;
            }
            first = first.next;
            second = second.next.next;
        }
    }

    public boolean hasALoop() {
        if (head == null) {
            return false;
        }
        var slow = head;
        var fast = head.next;

        while (fast != slow) {
            if (fast == null || slow == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public void printIt() {
        var current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
