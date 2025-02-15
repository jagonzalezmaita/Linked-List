package com.mycompany.lists;

public class CircularLinkedList implements LinkedList{
    private CircularNode root;
    private CircularNode tail;

    public CircularLinkedList(){
        root=null;
        tail=null;
    }

    @Override
    public boolean insert(int value){
        CircularNode newNode = new CircularNode(value);
        if (root==null){
            newNode.setNext(newNode);
            root=newNode;
            tail= newNode;
        }else{
            tail.setNext(newNode);
            newNode.setNext(root);
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

        CircularNode current=root;
        CircularNode previous=null;

        do{
            if (current.getValue()==value){
                if(current==root){
                    if (root==tail){ // Si hay solo un nodo en la lista, ambos root y tail deben ser null
                        root=null;
                        tail=null;
                    }else{
                        // Si hay más de un nodo, actualizamos root
                        root = current.getNext();
                        tail.setNext(root);  // El último nodo debe apuntar al nuevo root
                    }                    
                }else{  // Caso del nodo a eliminar está en medio o es el último nodo
                    previous.setNext(current.getNext());
                    if (current == tail){
                        tail=previous;
                    }
                }
                return true;    // Nodo eliminado con éxito
            }
            // Avanzamos al siguiente nodo
            previous=current;
            current=current.getNext();
        }while(current != root);    // Continuamos hasta regresar al root

        return false;    // No se encontró el valor en la lista
    }
    
    @Override
    public void display(){
        CircularNode temp = root;
        if (root == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        do{
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext();
        }while (temp != root);
        System.out.println("(y regresa al inicio)");
    }
    
    
    public CircularNode getRoot() {
        return root;
    }

    public void setRoot(CircularNode root) {
        this.root = root;
    }

    public CircularNode getTail() {
        return tail;
    }

    public void setTail(CircularNode tail) {
        this.tail = tail;
    }
}