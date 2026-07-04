# CRUD de Libros con JavaFX y MySQL

Este proyecto consiste en desarrollar una aplicación de escritorio utilizando **JavaFX** y **MySQL** para realizar las operaciones básicas de un CRUD (Crear, Leer, Actualizar y Eliminar) sobre una tabla de libros.

---

# Requisitos

Antes de comenzar, asegúrese de tener instalado:

- Java JDK 17 o superior
- IntelliJ IDEA (o cualquier IDE compatible con JavaFX)
- MySQL Server
- MySQL Workbench (opcional)
- JavaFX SDK

---

# Paso 1. Crear la Base de Datos

Abrir MySQL Workbench (o cualquier cliente MySQL) y ejecutar el siguiente script.

```sql
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genero VARCHAR(50) NOT NULL
);

INSERT INTO libros (titulo, autor, anio, isbn, genero) VALUES
('Cien años de soledad','Gabriel García Márquez',1967,'9780307474728','Novela'),
('1984','George Orwell',1949,'9780451524935','Ciencia Ficción'),
('El Principito','Antoine de Saint-Exupéry',1943,'9780156012195','Infantil');
```

---

# Paso 2. Crear el Proyecto

Crear un nuevo proyecto JavaFX desde IntelliJ IDEA.

La estructura del proyecto será similar a:

```
src
 └── main
      ├── java
      │      └── org.example.prueba_2
      │              Conexion.java
      │              Libro.java
      │              crudController.java
      │              HelloApplication.java
      │
      └── resources
             └── org.example.prueba_2
                     crud.fxml
```

---

# Paso 3. Crear la Clase de Conexión

Crear una clase llamada **Conexion.java**.

Esta clase será la encargada de establecer la conexión con la base de datos MySQL utilizando JDBC.

Actualizar:

- Usuario
- Contraseña
- Nombre de la base de datos

según la configuración del equipo.

---

# Paso 4. Crear la Clase Libro

Crear la clase **Libro.java**.

Esta clase representa cada registro almacenado en la tabla **libros**.

Debe contener los siguientes atributos:

- id
- titulo
- autor
- anio
- isbn
- genero

Además de:

- Constructor
- Getters
- Setters

---

# Paso 5. Diseñar la Interfaz

Crear un archivo **crud.fxml**.

La interfaz contiene:

- TextField para el título
- TextField para el autor
- TextField para el año
- TextField para el ISBN
- ComboBox para el género
- TableView para visualizar los registros
- Botones:
  - Guardar
  - Editar
  - Eliminar
  - Limpiar

---

# Paso 6. Configurar el TableView

Agregar las siguientes columnas:

- ID
- Título
- Autor
- Año
- ISBN
- Género

Estas columnas serán enlazadas con los atributos de la clase **Libro** mediante `PropertyValueFactory`.

---

# Paso 7. Implementar el Controlador

Crear la clase **crudController.java**.

En ella se implementan las operaciones:

- Inicializar el ComboBox.
- Configurar las columnas del TableView.
- Cargar los libros desde la base de datos.
- Capturar la fila seleccionada.
- Guardar un nuevo libro.
- Actualizar un libro existente.
- Eliminar un libro.
- Limpiar los campos.

---

# Paso 8. Ejecutar la Aplicación

Ejecutar la clase principal del proyecto.

Al iniciar la aplicación:

- El ComboBox mostrará los géneros disponibles.
- El TableView cargará automáticamente los registros almacenados en MySQL.

---

# Paso 9. Probar las Operaciones CRUD

## Crear

Ingresar:

- Título
- Autor
- Año
- ISBN
- Género

Presionar **Guardar**.

El nuevo libro aparecerá en la tabla.

---

## Leer

Al abrir la aplicación se visualizarán todos los registros almacenados en la base de datos.

---

## Actualizar

1. Seleccionar un libro.
2. Modificar cualquier dato.
3. Presionar **Editar**.

El registro se actualizará inmediatamente.

---

## Eliminar

1. Seleccionar un libro.
2. Presionar **Eliminar**.

El registro desaparecerá de la base de datos y del TableView.

---

# Resultado

La aplicación permite administrar un catálogo de libros realizando las cuatro operaciones básicas de un CRUD:

- Crear
- Leer
- Actualizar
- Eliminar

Todo ello mediante una interfaz desarrollada en JavaFX y persistiendo la información en una base de datos MySQL.

---

# Tecnologías utilizadas

- Java 17
- JavaFX
- JDBC
- MySQL
- IntelliJ IDEA
