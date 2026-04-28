# EscuRed - Sistema de Gestión y Control Escolar

EscuRed es una plataforma integral desarrollada en Java 17 utilizando el framework Spring Boot. Está diseñada para administrar el flujo operativo de una institución educativa, permitiendo la gestión de alumnos, profesores, asignaturas, inscripciones, control de asistencias y generación automatizada de reportes en PDF con envío por correo electrónico.

## Arquitectura y Tecnologías
* **Backend:** Spring Boot (Web, Data JPA, Security, Mail, Validation).
* **Seguridad:** JSON Web Tokens (JWT) con Refresh Tokens, implementado a través de Cookies seguras (HttpOnly) para integración fluida con la capa de vistas.
* **Frontend:** Thymeleaf, HTML5, Bootstrap 5.
* **Base de Datos:** MariaDB.
* **Herramientas Adicionales:** Lombok, OpenPDF para reportes, Maven.

---

## Ejecución del Proyecto

### Prerrequisitos
1. **Java JDK 17** instalado en el sistema.
2. **MariaDB** instalado y en ejecución en el puerto `3306`.
3. **Maven** instalado (opcional si se usa el wrapper incluido).
4. Configurar las credenciales de la base de datos en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/escuela
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_PASSWORD

Pasos para iniciar la aplicación
Clona o extrae el código fuente del proyecto.

Abre una terminal y navega a la raíz del proyecto.

Ejecuta el siguiente comando para limpiar y compilar el proyecto (ejemplo en sistemas basados en Debian/Linux o Windows):

Bash
mvn clean install
Inicia la aplicación con:

Bash
mvn spring-boot:run
(Nota: El archivo data.sql se ejecutará automáticamente insertando roles, usuarios y registros de prueba iniciales).

Abre un navegador web y dirígete a: http://localhost:8080/

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