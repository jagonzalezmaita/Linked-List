package com.mycompany.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mycompany.lists.LinkedList;
import com.mycompany.lists.SingleLinkedList;
import com.mycompany.lists.CircularLinkedList;
import com.mycompany.lists.DoubleLinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear la lista enlazada
        LinkedList simpleNodeList = new SingleLinkedList();
        LinkedList doubleNodeList = new DoubleLinkedList();
        LinkedList circularNodeList = new CircularLinkedList();
        LinkedList currentList = null;
        String typeList[]={"Lista Simple","Lista Doble", "Lista Circular"};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //menu principal
            System.out.println("\nMenú:");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Doble");
            System.out.println("3. Lista Circular");
            System.out.println("4. Salir");
            System.out.print("Elige una opción (1-4): ");            
            int option = 0; // Inicializamos la opción a un valor no válido            
            try {
                option = scanner.nextInt();  // Intentamos leer un valor entero
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario no ingresa un número entero
                System.out.println("¡Error! Debes ingresar un número entero.");
                scanner.nextLine();  // Limpiamos el buffer del scanner
                continue;  // Volvemos a pedir la opción sin continuar con el resto del código
            }

            if (option == 4){   //Elección de terminar ejecución app
                System.out.println("Saliendo...");
                break;
            }
            
            if(option==1 || option==2 || option==3){
                while (true) {
                    System.out.println("\n"+typeList[option-1]+" Operaciones disponibles:");
                    System.out.println("1. Insertar un valor");
                    System.out.println("2. Eliminar un valor");
                    System.out.println("3. Mostrar la lista");
                    System.out.println("4. Volver al menú principal");
                    System.out.print("Elige una operación (1-4): ");                
                    int operation = 0;
                    try {
                        operation = scanner.nextInt();  // Intentamos leer un valor entero
                    } catch (InputMismatchException e) {
                        // Captura la excepción si el usuario no ingresa un número entero
                        System.out.println("¡Error! Debes ingresar un número entero.");
                        scanner.nextLine();  // Limpiamos el buffer del scanner
                        continue;  // Volvemos a pedir la opción sin continuar con el resto del código
                    }
                    if (operation == 4){    //elección de regresar al menú principal
                        System.out.println("Regresando al menú principal...");
                        break;
                    } 
                    if (option==1){
                        currentList=simpleNodeList;
                    }else if (option==2){
                        currentList=doubleNodeList;
                    }else if (option==3){
                        currentList=circularNodeList;
                    }

                    int value;
                    switch (operation) {
                        case 1:
                            //insertar en listas
                            System.out.println("Actual lista:");
                            currentList.display();
                            System.out.println("Ingrese el valor del Nodo a insertar:");
                            value=0;
                            try {
                                value = scanner.nextInt();  // Intentamos leer un valor entero
                            } catch (InputMismatchException e) {
                                // Captura la excepción si el usuario no ingresa un número entero
                                System.out.println("¡Error! Debes ingresar un número entero.");
                                scanner.nextLine();  // Limpiamos el buffer del scanner 
                                break;                                  
                            }                                
                            if (currentList.insert(value)==true){
                                System.out.println("Se ha insertado el Nodo con el valor: "+value+" la nueva lista:");
                                currentList.display();
                            }else{
                                System.out.println("No se ha insertado el nuevo Nodo con el valor: "+value+" la lista:");
                                currentList.display();
                            }
                            break;
                        case 2:
                            // eliminar en listas
                            System.out.println("Actual lista:");
                            currentList.display();
                            System.out.println("Ingrese el valor del Nodo a eliminar:");
                            value=0;
                            try {
                                value = scanner.nextInt();  // Intentamos leer un valor entero
                            } catch (InputMismatchException e) {
                                // Captura la excepción si el usuario no ingresa un número entero
                                System.out.println("¡Error! Debes ingresar un número entero.");
                                scanner.nextLine();  // Limpiamos el buffer del scanner       
                                break;                             
                            }
                            if (currentList.removeNode(value)==true){
                                System.out.println("Se ha eliminado el Nodo con el valor: "+value+" la nueva lista:");
                                currentList.display();
                            }else{
                                System.out.println("No existe un Nodo con el valor: "+value+" la lista:");
                                currentList.display();
                            }
                            break;
                        case 3:
                            // mostrar listas
                            currentList.display();                            
                            break;                        
                        default:
                        System.out.println("Error, ingrese una operación válida (1-4)");
                            continue;
                    }
                }
            }else{
                System.out.println("Error, ingrese una operación válida (1-4)");
            }
        }
        scanner.close();
    }
}