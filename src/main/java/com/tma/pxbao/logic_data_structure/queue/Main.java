package com.tma.pxbao.logic_data_structure.queue;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.enqueue("Tomato");
        myQueue.enqueue("Banana");
        myQueue.enqueue("Lemon");
        myQueue.enqueue("Strawberry");
        myQueue.enqueue("Orange");
        myQueue.enqueue("Apple");

        myQueue.print();

        System.out.println("\n\nElement by dequeue Queue: " + myQueue.dequeue());
        System.out.println("Queue after dequeue element");
        myQueue.print();

        System.out.println("\n\nElement on the front of Queue: " + myQueue.front());
        System.out.println("Queue after get front element");
        myQueue.print();

        System.out.println("\n\nElement on the rear of Queue: " + myQueue.rear());
        System.out.println("Queue after get rear element");
        myQueue.print();
    }
}
