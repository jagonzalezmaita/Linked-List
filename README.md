# Proyecto de Manejo de Listas Enlazadas en Java

Este proyecto proporciona una implementación simple de varias estructuras de datos de listas enlazadas en Java. Incluye tres tipos de listas:
- Lista Enlazada Simple (Singly Linked List)
- Lista Enlazada Doble (Doubly Linked List)
- Lista Enlazada Circular (Circular Linked List)

Las listas implementan las operaciones básicas como:
- Insertar un valor
- Eliminar un valor
- Mostrar la lista

## Estructuras de Datos Implementadas

Para este caso, notar que las 3 listas además de terner la referencia a "root" también tienen una referencia a "tail" (último elemento).

### 1. Lista Enlazada Simple
Definición:

En una lista enlazada simple con referencias a ROOT y TAIL, cada nodo contiene:

* Valor o dato: La información almacenada en el nodo.
* Referencia al siguiente nodo: Un puntero al siguiente nodo en la lista.

En esta implementación, ROOT apunta al primer nodo de la lista y TAIL apunta al último nodo. El último nodo de la lista, en lugar de apuntar a null, puede apuntar a TAIL, pero para mantener la estructura simple, normalmente TAIL sigue siendo una referencia adicional a optimización.

Características:

* Acceso secuencial: Para acceder a un nodo en el medio de la lista, debes recorrer la lista desde ROOT hasta el nodo deseado.
* Operaciones eficientes al final: La referencia a TAIL hace que las operaciones de inserción y eliminación al final sean de O(1), ya que ya tienes acceso directo al último nodo.
* Inserción eficiente: La inserción al principio sigue siendo eficiente, pero insertar al final es mucho más rápido gracias a TAIL.

### 2. Lista Enlazada Doble
Definición:

En una lista enlazada doble con referencias a ROOT y TAIL, cada nodo contiene:

* Valor o dato: La información del nodo.
* Referencia al siguiente nodo: Un puntero al siguiente nodo.
* Referencia al nodo anterior: Un puntero al nodo anterior.

Aquí, la referencia a ROOT apunta al primer nodo y TAIL apunta al último nodo de la lista. Cada nodo tiene referencias tanto al siguiente como al anterior nodo, lo que facilita recorrer la lista en ambas direcciones.

Características:

* Acceso bidireccional: Al tener referencias a ambos, tanto al siguiente como al anterior nodo, puedes recorrer la lista en ambas direcciones.
* Operaciones eficientes al final y al principio: La referencia a TAIL facilita insertar y eliminar nodos al final de la lista de manera eficiente. Además, puedes eliminar nodos intermedios más rápido gracias a la referencia al nodo anterior.
* Mayor uso de memoria: Debido a que cada nodo tiene dos punteros (al siguiente y al anterior), consume más memoria que la lista simple.

Ventajas:

* Recorrido bidireccional: La capacidad de recorrer la lista hacia adelante y hacia atrás.
* Inserciones y eliminaciones más rápidas: Inserciones y eliminaciones al principio, medio y final son eficientes gracias a las referencias a ROOT y TAIL.

Desventajas:

* Mayor uso de memoria debido a los dos punteros por nodo.

### 3. Lista Enlazada Circular
Definición:

En una lista enlazada circular con referencias a ROOT y TAIL, la característica principal es que el TAIL apunta de vuelta al ROOT. Esto significa que el último nodo no tiene un puntero a null, sino que apunta al primer nodo, creando un ciclo. Además, en este caso también puedes tener una lista doble circular, en la que los nodos tienen referencias tanto al siguiente como al anterior nodo.

Lista Circular Simple:
En una lista circular simple, el último nodo apunta al primer nodo, creando un ciclo.

Lista Circular Doble:
En una lista circular doble, el primer nodo apunta al último nodo, y el último nodo apunta de vuelta al primer nodo, lo que permite un recorrido bidireccional.

Características:

* Recorrido continuo: Gracias a la estructura circular, puedes recorrer la lista sin llegar nunca al final. El último nodo apunta de nuevo al primer nodo, creando un ciclo.
* Recorrido bidireccional: En el caso de una lista doble circular, puedes recorrer la lista en ambas direcciones, lo que proporciona flexibilidad en las operaciones.
* Operaciones eficientes al final y al principio: La referencia a ROOT y TAIL hace que las operaciones de inserción y eliminación sean de O(1), tanto al principio como al final de la lista.

Ventajas:

* Recorrido continuo: Ideal para aplicaciones que requieren recorrer la lista repetidamente sin tener que volver al principio explícitamente.
* Inserciones y eliminaciones rápidas: Gracias a las referencias a ROOT y TAIL, puedes hacer inserciones y eliminaciones al principio y al final de manera eficiente.

Desventajas:

* Complejidad: La gestión de las conexiones circulares puede ser más compleja, y es fácil caer en bucles infinitos si no se maneja adecuadamente.

### 4. Tabla de comparación
| Característica                  | **Lista Simple (con ROOT y TAIL)**    | **Lista Doble (con ROOT y TAIL)**        | **Lista Circular Simple (con ROOT y TAIL)** | **Lista Circular Doble (con ROOT y TAIL)** |
|-----------------------------------|---------------------------------------|------------------------------------------|--------------------------------------------|--------------------------------------------|
| **Dirección del recorrido**      | Unidireccional                        | Bidireccional                            | Unidireccional (circular)                  | Bidireccional (circular)                   |
| **Acceso al nodo anterior**       | No disponible                         | Disponible                               | No disponible                              | Disponible                                 |
| **Uso de memoria**                | Menor (solo un puntero por nodo)      | Mayor (dos punteros por nodo)            | Menor (similar a lista simple)             | Mayor (similar a lista doble)              |
| **Insertar al final**             | O(1)                                  | O(1)                                     | O(1)                                       | O(1)                                       |
| **Eliminar al final**             | O(1)                                  | O(1)                                     | O(1)                                       | O(1)                                       |
| **Insertar al principio**         | O(1)                                  | O(1)                                     | O(1)                                       | O(1)                                       |
| **Eliminar un nodo específico**   | O(n)                                  | O(1) (si tienes el puntero al nodo)     | O(n) (más difícil que la simple)          | O(1) (si tienes el puntero al nodo)        |
| **Ventaja principal**             | Simplicidad y eficiencia al final     | Flexibilidad para recorrido bidireccional| Recorrido cíclico eficiente               | Recorrido cíclico bidireccional            |
| **Desventaja principal**          | Menor flexibilidad en el acceso      | Mayor uso de memoria y complejidad       | Mayor complejidad para gestionar ciclos    | Mayor complejidad para gestionar ciclos    |


## Operaciones Disponibles

Cada tipo de lista tiene las siguientes operaciones disponibles:

- **Insertar**: Agrega un nuevo nodo al final de la lista.
- **Eliminar**: Elimina un nodo de la lista que contenga un valor específico.
- **Mostrar**: Muestra los elementos de la lista.

## Ejemplo de Uso

Puedes elegir el tipo de lista que deseas usar desde un menú interactivo. A continuación se muestra cómo interactuar con el programa.

### Paso 1: Elegir el tipo de lista

```bash
Menú:
1. Lista Simple
2. Lista Doble
3. Lista Circular
4. Salir
Elige una opción (1-4):
```

### Paso 2: Realizar operaciones sobre la lista seleccionada

Una vez que selecciones un tipo de lista, el programa te ofrecerá las siguientes operaciones:

```bash
<Nombre de la lista> Operaciones disponibles:
1. Insertar un valor
2. Eliminar un valor
3. Mostrar la lista
4. Volver al menú principal
Elige una operación (1-4):
```

### Paso 3: Insertar, eliminar o mostrar nodos

Cuando seleccionas la operación "Insertar", se te pedirá que ingreses el valor a insertar:
```bash
Ingrese el valor del Nodo a insertar:
```
Al seleccionar la operación "Eliminar", se te pedirá el valor del nodo que deseas eliminar:
```bash
Ingrese el valor del Nodo a eliminar:
```


## Cómo Ejecutar el Proyecto

1. Clonar el repositorio: Si tienes el proyecto en un repositorio de Git, clónalo en tu máquina local.
```bash
    git clone <url_del_repositorio>
```
2. Compilar y ejecutar: 
    * Abre una terminal en la carpeta del proyecto.
    * Ejecuta el comando para compilar el proyecto con javac:
    ```bash
        javac com/mycompany/*.java
    ```
    * Ejecuta el programa con:
    ```bash
        java com.mycompany.main.Main
    ```


