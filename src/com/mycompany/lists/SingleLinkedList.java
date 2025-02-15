package com.mycompany.lists;

public class SingleLinkedList implements LinkedList {
    private Node root;
    private Node tail;


    public SingleLinkedList(){
        this.root=null;
        this.tail=null;
    }

    // Inserción optimizada: O(1) al tener la referencia tail, insertando directamente al final
    @Override
    public boolean insert(int value){
        Node newNode=new Node(value);
        if (root==null){
            root = newNode;
            tail= newNode;
        }else{            
            tail.setNext(newNode);
            tail=newNode;
        }
        return true;
    }

    // Búsqueda de un nodo: O(n)
    public Node searchNode(int value){
        Node current=root;
        while(current!=null){
            if (current.getValue()==value){
                return current;
            }
            current=current.getNext();
        }
        return null;
    }

    @Override
    public boolean removeNode(int value){
        // Se revisa que La lista está vacía, si es asi no se puede eliminar nada
        if (root == null) {
            return false;
        }

        Node current= root;
        Node previous=null;

        while(current!=null){
            if (current.getValue()==value){
                if(current==root){  // Caso donde eliminamos el primer nodo (root)
                    root=current.getNext();
                    if (root==null){    // Si la lista queda vacía
                        tail=null;
                    }                    
                }else{  // Caso donde se elimina un nodo intermedio o final
                    previous.setNext(current.getNext());
                    if (current==tail){     // Si el nodo eliminado es el último nodo
                        tail=previous;
                    }
                }
                return true;    // Nodo eliminado con éxito      
            }
            // Avanzamos al siguiente nodo
            previous=current;
            current=current.getNext();
        }
        return false;   // No se encontró el nodo con el valor especificado
    }

    @Override
    public void display() {
        Node temp = root;
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

    
    //Gets && Sets
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
