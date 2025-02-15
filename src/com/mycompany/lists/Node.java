package com.mycompany.lists;

public class Node {
    private int value;
    private Node next;

    public Node(int value){
        this.value=value;
        this.next=null;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
    
}
