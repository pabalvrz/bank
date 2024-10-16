# Aplicación de Gestión de Cuentas Bancarias

## Descripción

Este proyecto es una aplicación backend desarrollada con **Spring Boot** y **Java**, que expone una API REST para gestionar un sistema de cuentas bancarias. Permite realizar un CRUD (Crear, Leer, Actualizar y Eliminar) sobre las cuentas de banco, además de realizar operaciones adicionales como depositar y retirar dinero de una cuenta. La documentación de la API está disponible a través de **Swagger**.

### Funcionalidades:

- **CRUD de cuentas de banco:**
  - Crear una nueva cuenta.
  - Leer la información de una cuenta existente.
  - Actualizar los datos de una cuenta.
  - Eliminar una cuenta.
- **Operaciones adicionales:**
  - Depositar dinero en una cuenta.
  - Retirar dinero de una cuenta.
  
### Modelo de Cuenta de Banco:

- `id`: Identificador único autogenerado.
- `nif`: NIF del titular de la cuenta.
- `nombre`: Nombre completo del titular.
- `dinero`: Monto actual en la cuenta.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** (para la persistencia de datos)
- **H2** (Base de datos en memoria para pruebas)
- **Swagger** (para la documentación de la API)
- **Maven** (como gestor de dependencias)

## Requisitos

Para poder ejecutar el proyecto, necesitas tener instalados:

- Java 17+
- Maven 3.8+
  
## Endpoints Principales

### CRUD de Cuentas:

- **GET** `/api/bankAccount/` - Obtener todas las cuentas.
- **GET** `/api/bankAccount/{id}` - Obtener una cuenta específica por ID.
- **POST** `/api/bankAccount/create` - Crear una nueva cuenta.

### Operaciones de Depósito y Retiro:

- **POST** `/api/cuentas/{id}/deposit` - Depositar dinero en una cuenta.
- **POST** `/api/cuentas/{id}/withdraw` - Retirar dinero de una cuenta.

## Documentación con Swagger

Una vez que el servidor esté en funcionamiento, puedes acceder a la documentación completa de la API generada con Swagger en la siguiente URL: http://localhost:8080/swagger-ui.html

La aplicación utiliza una base de datos **H2** en memoria por defecto. Puedes acceder a la consola de la base de datos H2 en: http://localhost:8080/h2-console

### Credenciales de la Base de Datos:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuario**: `sa`
- **Contraseña**: `password`
