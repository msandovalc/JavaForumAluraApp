
# Forumalura

**Forumalura** 
Este proyecto es una API RESTful construida con **Spring Boot** para gestionar un foro de preguntas y respuestas. Permite crear, consultar, actualizar y eliminar preguntas y respuestas de los usuarios.

---

## Funcionalidades

- **Gestión de preguntas**: Crear, obtener por ID y eliminar preguntas.
- **Gestión de respuestas**: Crear respuestas asociadas a una pregunta específica.
- **Autenticación y autorización**: Utiliza JWT para la autenticación de usuarios y acceso a los recursos.
- **Validación de datos**: Uso de anotaciones de validación de Hibernate para garantizar la consistencia de los datos.

---

## **Estructura del Proyecto**

El proyecto está organizado utilizando las buenas prácticas de arquitectura de software y OOP:

```
src
└── main
├── java 
│ └── com 
│ └── msandoval 
│ └── project 
│ └── forum 
│ 
├── controller 
│ ├── dto 
│ ├── model 
│ ├── repository 
│ ├── security 
│ ├── service 
│ └── ForumApplication.java 
├── resources 
│ ├── application.properties 
│ └── static 
└── test
 └── java
 └── com
 └── msandoval
 └── project
 └── forum
 └── controller
 └── service



```

---

### Descripción de las carpetas y archivos

- **`controller`**: Contiene las clases que manejan las solicitudes HTTP.
    - `QuestionController.java`: Controlador para gestionar preguntas (crear, obtener por ID, eliminar).
    - `AnswerController.java`: Controlador para gestionar respuestas (crear, obtener por pregunta).
  
- **`dto`**: Contiene los objetos de transferencia de datos (DTO) utilizados para la comunicación entre la capa de presentación y la capa de servicio.
    - `QuestionDTO.java`: Representación de los datos de una pregunta.
    - `AnswerDTO.java`: Representación de los datos de una respuesta.

- **`model`**: Contiene las clases de modelo que representan las entidades del sistema.
    - `Question.java`: Entidad que representa una pregunta.
    - `Answer.java`: Entidad que representa una respuesta.
  
- **`repository`**: Contiene las interfaces que gestionan la persistencia de datos (acceso a la base de datos).
    - `QuestionRepository.java`: Repositorio para las operaciones CRUD sobre preguntas.
    - `AnswerRepository.java`: Repositorio para las operaciones CRUD sobre respuestas.

- **`security`**: Contiene clases relacionadas con la seguridad de la aplicación (autenticación y autorización).
    - `TokenService.java`: Servicio para la generación y validación de tokens JWT.
    - `JWTAuthenticationFilter.java`: Filtro que intercepta las solicitudes para validar los tokens JWT.

- **`service`**: Contiene las clases de servicio que implementan la lógica de negocio.
    - `QuestionService.java`: Servicio para manejar la lógica relacionada con preguntas.
    - `AnswerService.java`: Servicio para manejar la lógica relacionada con respuestas.

- **`ForumApplication.java`**: Clase principal de la aplicación Spring Boot.

---


## **Tecnologías Utilizadas**

Este proyecto utiliza una serie de tecnologías y herramientas para crear la API de foro. A continuación se enumeran las principales:

### Backend

- **Java 17+**: Lenguaje de programación utilizado para desarrollar la API.
- **Spring Boot 2.x**: Framework que facilita la creación de aplicaciones basadas en Spring, proporcionando un entorno de configuración y despliegue fácil y rápido.
- **Spring Security**: Módulo de Spring para manejar la autenticación y autorización de la aplicación. Se utiliza para asegurar los endpoints y generar/validar tokens JWT.
- **JPA (Java Persistence API)**: Se utiliza para interactuar con la base de datos y gestionar las entidades de las preguntas y respuestas de manera eficiente.
- **Spring Data JPA**: Herramienta que simplifica la implementación de la capa de acceso a datos, con repositorios automáticos basados en interfaces.
- **Hibernate**: Framework ORM utilizado para la interacción con la base de datos en el backend.
- **JWT (JSON Web Token)**: Tecnología para la autenticación basada en tokens, utilizada para manejar la seguridad y autorización.
- **Lombok**: Librería que ayuda a reducir el código repetitivo (como getters, setters, constructores, etc.) mediante anotaciones.

### Base de Datos

- **PostgreSQL**: Base de datos relacional utilizada para almacenar las preguntas y respuestas del foro.
  
### Desarrollo y Pruebas

- **JUnit 5**: Framework para la realización de pruebas unitarias en Java.
- **Mockito**: Framework para pruebas de mock (simulaciones) utilizado en las pruebas unitarias.
- **Insomnia**: Framework para pruebas de API (simulaciones) utilizado en las solicitudes de HTTP.

### Herramientas de Desarrollo

- **Maven**: Herramienta de gestión de proyectos y dependencias utilizada para construir el proyecto.
- **IDE**: Usado para el desarrollo y depuración del código (por ejemplo, IntelliJ IDEA, Eclipse).
  
### Documentación

- **Swagger UI**: Herramienta de documentación y prueba de API interactiva. Swagger UI se genera automáticamente cuando la aplicación se ejecuta, permitiendo visualizar y probar los endpoints directamente desde el navegador.

---

Estas 

---

## **Requisitos**

1. **Java**: Asegúrate de tener instalado Java 17 o superior.
2. **PostgreSQL**: Configura una base de datos PostgreSQL con las siguientes credenciales:
   - **Base de datos**: `alura_literalura`
   - **Usuario**: `postgres`
   - **Contraseña**: `password` (ajustar según tu configuración local).

---

## **Configuración**

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/foro-api.git
   cd literalura
   ```

2. Configura la conexión a la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/alura_forum
   spring.datasource.username=postgres
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Instala las dependencias y compila el proyecto:
   ```bash
   ./mvnw clean install
   ```

4. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## **Interacción con la API**

Una vez que la aplicación esté en ejecución, puedes interactuar con ella a través de Swagger UI:
	http://localhost:8080/swagger-ui.html.
 
Para realizar solicitudes a los endpoints protegidos, debes incluir el token JWT en los encabezados HTTP como Authorization: 
	Bearer <token>.

---

## **Generar el JWT:**

Puedes generar el token JWT desde el endpoint de autenticación (si implementas uno) o usar una herramienta externa para generar un token con un payload adecuado.

---

## **Pruebas**

El proyecto incluye pruebas unitarias para la lógica de negocio en los servicios y pruebas de integración para los repositorios de JPA. Ejecuta las pruebas con:

Endpoints de la API
1.- POST /questions: Crear una nueva pregunta.

Request Body:
{
  "title": "¿Cómo resolver un problema de álgebra?",
  "content": "Necesito ayuda con un problema de álgebra lineal."
}

Response:
{
  "id": 1,
  "title": "¿Cómo resolver un problema de álgebra?",
  "content": "Necesito ayuda con un problema de álgebra lineal.",
  "createdAt": "2024-12-01T15:00:00"
}


2.- GET /questions/{id}: Obtener una pregunta por ID.

3.- DELETE /questions/{id}: Eliminar una pregunta por ID.

4.- POST /answers: Crear una nueva respuesta para una pregunta.
Request Body:
{
  "content": "Usa la regla de Cramer para resolver este tipo de problemas.",
  "questionId": 1
}

Response:
{
  "id": 1,
  "content": "Usa la regla de Cramer para resolver este tipo de problemas.",
  "questionId": 1,
  "createdAt": "2024-12-01T15:30:00"
}

5.- GET /answers/question/{questionId}: Obtener todas las respuestas de una pregunta específica.

---



## **Créditos**

Desarrollado por **Manuel Sandoval** como parte del desafío **ForumAlura API**.
