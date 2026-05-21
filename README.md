# Microservicio: ms-productos

## Descripción
Microservicio responsable de la gestión del catálogo de productos. Permite la administración completa de los artículos disponibles para la venta.

## Tecnologías Utilizadas
* **Java 21** / Spring Boot 3.x
* **Gestor de dependencias**: Maven
* **Base de Datos**: PostgreSQL (Neon.tech)
* **Contenedorización**: Docker
* **Despliegue**: Render

## Endpoints Disponibles
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/productos` | Lista todos los productos disponibles. |
| `POST` | `/api/productos` | Registra un nuevo producto en el catálogo. |
| `PUT` | `/api/productos/{id}` | Actualiza la información de un producto existente. |
| `DELETE` | `/api/productos/{id}` | Elimina un producto del catálogo. |

## Variables de Entorno Necesarias
* `SPRING_DATASOURCE_URL`
* `SPRING_DATASOURCE_USERNAME`
* `SPRING_DATASOURCE_PASSWORD`

## Instrucciones para Ejecutar en Local
1. Clonar el repositorio.
2. Configurar la conexión a la base de datos de Neon en `src/main/resources/application.properties`.
3. Ejecutar: `mvn spring-boot:run`


## Instrucciones Básicas de Despliegue
Este proyecto está configurado para despliegue automático en **Render**:
1. Conectar el repositorio de GitHub a Render.
2. Configurar el *Build Command*: `mvn clean package -DskipTests`
3. Configurar el *Start Command*: `java -jar target/*.jar`
4. Añadir las variables de entorno de conexión a base de datos.

En este caso las conexiones a Render ya se realizaron.
Configuración de la petición:
1. Abre Postman y crea una nueva Request.
2. Selecciona el método HTTP correspondiente (ej. GET para listar, POST para crear).
3. En la barra de direcciones, escribe el siguiente endpoint:
Enlaces de despliegue en Render (API lista para probar en Postman):
 - Productos: https://ms-productos-pmew.onrender.com/api/productos

---
**Examen Final | Docente: Nike Rodriguez**
**CodiGo By Tecsup**
