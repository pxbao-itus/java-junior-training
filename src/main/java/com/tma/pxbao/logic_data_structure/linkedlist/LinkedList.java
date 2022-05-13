package com.tma.pxbao.logic_data_structure.linkedlist;

public class LinkedList<T> {
    Node head;
    int length = 0;

    static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    // Add new node to tail of linked list
    public static <T> LinkedList add(LinkedList<T> linkedList, T data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            Node last = linkedList.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        linkedList.length++;
        return linkedList;
    }

    public static <T> void print(LinkedList<T> linkedList) {
        Node currentNode = linkedList.head;
        System.out.println("Linked List: ");

        while (currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    // insert new node to specify position
    public static <T> LinkedList insert(LinkedList linkedList, T data, int position) {
        Node newNode = new Node(data);
        newNode.next = null;
        int indexCount = 1;
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            Node currentNode = linkedList.head;
            while (indexCount != position) {
                currentNode = currentNode.next;
                indexCount++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        return linkedList;
    }

    // get node at position input from user
    public static <T> T get(LinkedList linkedList, int position) throws IndexOutOfBoundsException {
        if (position > linkedList.length) {
            System.out.println("\n\nError: " + new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = linkedList.head;
        int index = 0;
        while (index < position - 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            index++;
        }
        return (T) currentNode.data;
    }

    // default remove final element of linked list
    // args[0] is position of element that is removed, args[2] is element has data that is equal
    public static <T> void remove(LinkedList linkedList, Object... args) {
        Integer position = -1; // default position for case that user provides data of node
        if (args.length == 0) {// parameters just contain list
            //default remove tail of list ==> position is end of list
            position = linkedList.length - 1;

        }
        if (args.length == 1) {// parameters contain list, position
            position = (Integer) args[0];
        }
        Node currentNode = linkedList.head;
        int index = 0;

        // Case user provides data of node
        if (position == -1) {
            removeWithData:
            while (currentNode.next != null) {
                if (currentNode.next.data.equals(args[1])) {
                    currentNode.next = currentNode.next.next;
                    break removeWithData;
                }
                currentNode = currentNode.next;
            }
            return;
        } else {
            // Case user provides position of node
            while (index < position - 1) {
                currentNode = currentNode.next;
                index++;
            }
            currentNode.next = currentNode.next.next;
            return;
        }
    }

}
