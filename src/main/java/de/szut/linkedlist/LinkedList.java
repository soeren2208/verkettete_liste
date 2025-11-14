package de.szut.linkedlist;

public class LinkedList<T> {
    private int size = 0;
    private Node first;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void add(T value) {
        if(isEmpty()){
            this.first = new Node(value);
        }
        else{
            Node current = findNodeAtIndex(size-1);
            current.next = new Node(value);
        }
        this.size++;
    }

    private Node findNodeAtIndex(int index){
        Node current = this.first;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    public T get(int index) {
        if(isEmpty()){
            return null;
        }
        else{
            return findNodeAtIndex(index).value;
        }
    }

    public T remove(int index) {
        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("Index " + index + " out of bounds.");
        }
        Node current = first;
        Node previous = null;
        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            this.first = this.first.next;
        }
        else{
            previous.next = current.next;
        }
        this.size--;
        return current.value;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
