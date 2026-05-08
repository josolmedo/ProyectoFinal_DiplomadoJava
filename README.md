# EscuRed - Sistema de Gestión y Control Escolar

EscuRed es una plataforma integral desarrollada en Java 17 utilizando el framework Spring Boot. Está diseñada para administrar el flujo operativo de una institución educativa, permitiendo la gestión de alumnos, profesores, asignaturas, inscripciones, control de asistencias y generación automatizada de reportes en PDF con envío por correo electrónico.

---

## Características Principales

* **Gestión Multi-Perfil:** Control de acceso basado en roles (Administrador, Profesor, Alumno, Padre de Familia).
* **Seguridad Avanzada:** Autenticación mediante JWT con doble token (Access y Refresh) almacenados en Cookies seguras.
* **Módulo Académico:** CRUD completo de alumnos, profesores, asignaturas y grupos.
* **Control de Inscripciones:** Proceso de matriculación de alumnos en grupos específicos.
* **Pase de Lista:** Registro de asistencia diaria con validación de duplicidad por fecha.
* **Evaluación Continua:** Gestión de calificaciones por parte de los profesores.
* **Reportes Automáticos:** Generación de boletas e historiales en PDF mediante **OpenPDF**.
* **Notificaciones Email:** Envío de reportes adjuntos vía SMTP (JavaMailSender).

---

## Stack Tecnológico

* **Lenguaje:** Java 17
* **Framework Principal:** Spring Boot 3.x
* **Seguridad:** Spring Security 6.x + JJWT (0.11.5)
* **Persistencia:** Spring Data JPA + MariaDB 11
* **Frontend:** Thymeleaf + Bootstrap 5 + jQuery
* **Gestión de Dependencias:** Maven
* **Otras Librerías:** Lombok, MapStruct, OpenPDF

---


## Estructura de Paquetes

* `dgtic.core.config`: Configuraciones de Beans, MVC y Seguridad.
* `dgtic.core.controller`: Controladores para vistas Thymeleaf y Endpoints REST.
* `dgtic.core.model`:
    * `.entity`: Entidades de persistencia JPA.
    * `.dto`: Objetos de transferencia de datos con validaciones.
* `dgtic.core.repository`: Interfaces de acceso a datos (Spring Data).
* `dgtic.core.service`: Capa de lógica de negocio e integraciones.
* `dgtic.core.security`: Implementación de filtros y proveedores JWT.

---

## Instalación y Despliegue

### Requisitos Previos
1.  **JDK 17** o superior.
2.  **MariaDB** instalado y corriendo.
3.  **Maven** instalado.

### Configuración de Base de Datos
1.  Accede a tu gestor de MariaDB y crea la base de datos:
    ```sql
    CREATE DATABASE escuela;
    ```
2.  Configura las credenciales en el archivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_password
    ```

### Ejecución
1.  Clona el repositorio o descarga el código.
2.  Compila y ejecuta el proyecto con Maven:
    ```bash
    mvn spring-boot:run
    ```
3.  La aplicación estará disponible en: [http://localhost:8080](http://localhost:8080)

> **Nota:** El sistema utiliza `data.sql` para cargar automáticamente los roles y usuarios de prueba (Admin, Profesor, Alumno) al primer arranque.

---

Manual de Uso y Flujo de la Aplicación
El sistema basa su navegación en un control de acceso por roles. Dependiendo del usuario autenticado, el menú de navegación (Navbar) presentará diferentes opciones.

1. Acceso al Sistema (Login)
   Ingresa a /login.

El sistema valida las credenciales y, mediante Spring Security, genera un Access Token y un Refresh Token (JWT).

Estos tokens se almacenan en el navegador como Cookies HttpOnly para protegerlos de ataques XSS. Thymeleaf y Spring utilizan estas cookies para mantener la sesión de manera Stateless.

2. Flujo del Administrador (Rol: ADMIN)
   Credenciales de prueba: admin@escuela.mx / hash_admin (Ajustar según la BD)

Gestión de Catálogos: Puede crear, editar y eliminar Asignaturas, Grupos, Alumnos y Profesores.

Inscripciones: A través de la opción "Inscribir Alumno a Materia", relaciona a un estudiante con un grupo específico.

Reportes: En la vista de Grupos, puede generar un reporte PDF de toda la carga académica de la escuela y enviarlo a su correo electrónico de administrador con un solo clic.

3. Flujo del Profesor (Rol: PROFESOR)
   Mis Grupos: Visualiza únicamente los grupos y materias que le han sido asignados, junto con la lista de alumnos inscritos.

Calificaciones: Permite al docente asignar o actualizar la calificación final de sus estudiantes.

Notificaciones: El profesor puede generar la "Boleta" en PDF de un alumno y utilizar el botón "Enviar Boleta" para que el sistema la envíe automáticamente por correo al alumno (y a su padre/tutor si está registrado).

4. Flujo del Alumno (Rol: ALUMNO)
   Mi Portal: Accede a la lista de materias en las que está inscrito.

Asistencias: Selecciona la materia del día y registra su asistencia. El sistema valida que no existan registros duplicados para la misma fecha y grupo.

Historial: Puede descargar un reporte PDF con todo su récord de asistencias o enviarlo a su correo institucional.

---

## Detalles de Seguridad

El sistema utiliza un esquema **Stateless**:
1.  **Login:** El usuario envía credenciales, el servidor valida y genera un **Access Token** (15 min) y un **Refresh Token** (7 días).
2.  **Cookies:** Los tokens se envían al navegador en Cookies con bandera `HttpOnly`, lo que impide el acceso desde JavaScript y mitiga ataques XSS.
3.  **Filtro:** Cada petición es interceptada por `JWTAuthenticationFilter`, que valida la firma del token antes de autorizar el acceso a la vista.

---

## Autores y Créditos

* **Desarrollador:** José Ángel Olmedo Guevara
* **Institución:** UNAM - DGTIC
* **Módulo:** Spring Security (Diplomado Java)
