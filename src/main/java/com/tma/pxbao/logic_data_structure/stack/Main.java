package com.tma.pxbao.logic_data_structure.stack;

public class Main {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("Tomato");
        myStack.push("Banana");
        myStack.push("Lemon");
        myStack.push("Strawberry");
        myStack.push("Orange");
        myStack.push("Apple");

        myStack.print();

        System.out.println("\n\nElement by popping Stack: " + myStack.pop());
        System.out.println("Stack after popped");
        myStack.print();

        System.out.println("\n\nElement by peeking Stack: " + myStack.peek());
        System.out.println("Stack after peeked");
        myStack.print();
    }


}
