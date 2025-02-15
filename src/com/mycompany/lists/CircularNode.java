package com.mycompany.lists;

public class CircularNode {
    private int value;
    private CircularNode next;

    public CircularNode(int value){
        this.value=value;
        this.next=null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CircularNode getNext() {
        return next;
    }
    
    public void setNext(CircularNode next) {
        this.next = next;
    }
}
