package com.grados.mywork.part1.linkedlist;

public class MyLinkedList {
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;


    public void addLast(int item) {
        Node node = new Node(item);

        if (first == null) {
            first = last = node;
            size++;
            return;
        }

        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        last = node;
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (first == null) {
            first = last = node;
            size++;
            return;
        }

        node.next = first;
        first = node;

    }

    public int indexOf(int item) {

        if (first == null) {
            return -1;
        }
        if (first.value == item) {
            return 0;
        }

        Node current = first.next;

        int index = 1;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (first == null) {
            return;
        }
        if (first.next == null) {
            return;
        }

        first = first.next;
        size--;

    }

    public void removeLast() {
        if (first == null)
            return;

        Node current = first;
        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                last = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        if (first == null)
            return null;
        Node current = first;

        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse() {
        if (size == 0 || size == 1)
            return;

        Node current;

        current = first;
        first = last;
        last = current;

        Node prev = last;
        current = last.next;
        Node next = last.next.next;

        while (current.next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        last.next = null;
    }

    public void print() {
        if (first == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int getKthFromLast(int index) {
        if (first == null) {
            System.out.println("empty");
        }

        if (index > size || index < 0)
            System.out.println("index > size");

        if (index == size)
            return first.value;

        Node current = first;
        Node rear = first;

        while (--index > 0) {
            rear = rear.next;
        }
        while (rear != last) {
            rear = rear.next;
            current = current.next;
        }
        return current.value;
    }

    public void findMiddle() {
        if (first == null)
            return;
        Node current = first;
        Node rear = first;

        while (rear != null) {
            if (rear.next == null) {
                System.out.println(current.value);
                return;
            }
            if (rear.next.next == null) {
                System.out.println(current.value);
                System.out.println(current.next.value);
            }
            rear = rear.next.next;
            current = current.next;
        }
    }

    public boolean hasLoop() {
        if (first == null)
            return false;

        Node current = first;
        Node rear = first;

        while (rear != null) {
            if (rear.next == null) {
                return false;
            }
            rear = rear.next.next;
            current = current.next;
            if (rear == current) {
                return true;
            }
        }

        return false;
    }
}

