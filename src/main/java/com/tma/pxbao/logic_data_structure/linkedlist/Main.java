package com.tma.pxbao.logic_data_structure.linkedlist;

public class Main {
    public static void main(String[] args) {

        // Demo for LinkedList has String element
        System.out.println("Linked List String demo");
        LinkedList<String> linkedList = new LinkedList<>();

        // Add node to list
        LinkedList.add(linkedList,"Math");
        LinkedList.add(linkedList,"Chemistry")  ;
        LinkedList.add(linkedList,"Physical");

        // insert to list
        LinkedList.insert(linkedList, "Science", 1);

        // Remove from list a node with data of node
        LinkedList.remove(linkedList,1, "Physical");

        LinkedList.print(linkedList);

        // Get node with specify position
        System.out.print("Element 2th of linked list: " + LinkedList.get(linkedList,2));

        // Demo for LinkedList has Integer element
        System.out.println("\n\nLinked List int demo");
        LinkedList<Integer> linkedList1 = new LinkedList<>();

        // insert to list
        LinkedList.add(linkedList1, 2);
        LinkedList.add(linkedList1, 4);
        LinkedList.add(linkedList1, 6);

        // Insert to list
        LinkedList.insert(linkedList1, 5,2);

        // Remove from list a node with specify position
        LinkedList.remove(linkedList1,1);

        LinkedList.print(linkedList1);

        // Get node with specify position
        System.out.print("Element 1th of linked list: " + LinkedList.get(linkedList1,1));
    }
}
