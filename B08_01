package Hw9;

// TASK B08_01

public class RecursiveStack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {this.value = value; this.next = next;}
    }
    private Node<T> topElement;
    
    public boolean isEmpty() {return topElement == null;}

    public void add(T value) {topElement = new Node<>(value, topElement);}

    public T pop() {
        if (topElement == null) {System.out.println("Stack is empty!");}
        T value = topElement.value;
        topElement = topElement.next;
        return value;
    }

    public T peek() {
        if (topElement == null) {System.out.println("Stack is empty!");}
        return topElement.value;
    }

    public static void main(String[] args) {
        RecursiveStack<Integer> intStack = new RecursiveStack<>();
        
        intStack.add(1);
        intStack.add(3);
        intStack.add(5);
        intStack.add(7);
        intStack.add(9);

        System.out.println("INTEGER STACK");
        System.out.println("Is empty: " + intStack.isEmpty());
        System.out.println("Top element: " + intStack.peek());
        System.out.println("Removing top element: " + intStack.pop());
        System.out.println("New top element: " + intStack.peek());

        RecursiveStack<String> stringStack = new RecursiveStack<>();
        stringStack.add("Java");
        stringStack.add("Hello");
        stringStack.add("World");
        
        System.out.println("STRING STACK");
        System.out.println("Is empty: " + stringStack.isEmpty());
        System.out.println("Top element: " + stringStack.peek());
        System.out.println("Removing top element: " + stringStack.pop());
        System.out.println("New top element: " + stringStack.peek());
    }
}
