package com.mycompany.lists;

public class DoubleLinkedList implements LinkedList{
    private DoubleNode root;
    private DoubleNode tail;


    public DoubleLinkedList(){
        this.root=null;
        this.tail=null;        
    }

    // Inserción optimizada: O(1) al tener la referencia tail, insertando directamente al final
    @Override
    public boolean insert(int value){
        DoubleNode newNode=new DoubleNode(value);
        if (root==null){
            root = newNode;
            tail= newNode;
        }else{            
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail=newNode;
        }
        return true;
    }

    @Override
    public boolean removeNode(int value){
        // Se revisa que La lista está vacía, si es asi no se puede eliminar nada
        if (root == null) {
            return false;
        }
        
        DoubleNode current=root;
        DoubleNode previous=null;

        while(current!= null){
            if (current.getValue()==value){                
                if(current==root){  //caso que el nodo a eliminar es root
                    root=current.getNext();
                    if (root!=null){
                        root.setPrevious(null); // Asegurar que el nuevo root no tiene referencia anterior
                    }else{
                        tail=null;
                    }
                }else{  //casos en que el nodo a eliminar está al final o despues de root
                    previous.setNext(current.getNext());
                    if (current.getNext() != null){   
                        current.getNext().setPrevious(previous);
                    }else{
                        tail=previous;   // Si el nodo eliminado era el último, actualizamos el tail
                    }
                }
                return true;    // Nodo eliminado con éxito
            }
            // Avanzamos al siguiente nodo
            previous=current;
            current=current.getNext();
        }
        return false;    // Nodo no encontrado
    }

    @Override
    public void display() {
        DoubleNode temp = root;
        if (root == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }


    public DoubleNode getRoot() {
        return root;
    }

    public void setRoot(DoubleNode root) {
        this.root = root;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }
}
