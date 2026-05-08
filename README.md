# EscuRed - Sistema de Gestión y Control Escolar

EscuRed es una plataforma integral desarrollada en Java 17 utilizando el framework Spring Boot. Está diseñada para administrar el flujo operativo de una institución educativa, permitiendo la gestión de alumnos, profesores, asignaturas, inscripciones, control de asistencias y generación automatizada de reportes en PDF con envío por correo electrónico.

---

## 🚀 Características Principales

* **Gestión Multi-Perfil:** Control de acceso basado en roles (Administrador, Profesor, Alumno, Padre de Familia).
* **Seguridad Avanzada:** Autenticación mediante JWT con doble token (Access y Refresh) almacenados en Cookies seguras.
* **Módulo Académico:** CRUD completo de alumnos, profesores, asignaturas y grupos.
* **Control de Inscripciones:** Proceso de matriculación de alumnos en grupos específicos.
* **Pase de Lista:** Registro de asistencia diaria con validación de duplicidad por fecha.
* **Evaluación Continua:** Gestión de calificaciones por parte de los profesores.
* **Reportes Automáticos:** Generación de boletas e historiales en PDF mediante **OpenPDF**.
* **Notificaciones Email:** Envío de reportes adjuntos vía SMTP (JavaMailSender).

---

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17
* **Framework Principal:** Spring Boot 3.x
* **Seguridad:** Spring Security 6.x + JJWT (0.11.5)
* **Persistencia:** Spring Data JPA + MariaDB 11
* **Frontend:** Thymeleaf + Bootstrap 5 + jQuery
* **Gestión de Dependencias:** Maven
* **Otras Librerías:** Lombok, MapStruct, OpenPDF

---


## 📂 Estructura de Paquetes

* `dgtic.core.config`: Configuraciones de Beans, MVC y Seguridad.
* `dgtic.core.controller`: Controladores para vistas Thymeleaf y Endpoints REST.
* `dgtic.core.model`:
    * `.entity`: Entidades de persistencia JPA.
    * `.dto`: Objetos de transferencia de datos con validaciones.
* `dgtic.core.repository`: Interfaces de acceso a datos (Spring Data).
* `dgtic.core.service`: Capa de lógica de negocio e integraciones.
* `dgtic.core.security`: Implementación de filtros y proveedores JWT.

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
