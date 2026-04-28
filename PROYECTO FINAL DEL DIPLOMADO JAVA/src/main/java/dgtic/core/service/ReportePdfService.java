package dgtic.core.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Grupos;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.model.entity.Usuarios;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportePdfService {

    public byte[] generarReporteCalificaciones(List<Inscripciones> inscripciones, Usuarios usuario) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Reporte de Calificaciones - EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Datos del alumno
            documento.add(new Paragraph("Alumno: " + usuario.getNombre() + " " + usuario.getApellido()));
            documento.add(new Paragraph("Correo: " + usuario.getEmail()));
            documento.add(new Paragraph(" ")); // Espacio

            // Tabla de calificaciones
            PdfPTable tabla = new PdfPTable(3); // 3 columnas
            tabla.setWidthPercentage(100);

            // Encabezados
            String[] encabezados = {"Asignatura", "Grupo", "Calificación"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(200, 200, 200));
                tabla.addCell(celda);
            }

            // Llenar datos
            for (Inscripciones ins : inscripciones) {
                tabla.addCell(ins.getGrupo().getAsignatura().getNombre());
                tabla.addCell(ins.getGrupo().getNombre());
                tabla.addCell(ins.getCalificacion() != null ? ins.getCalificacion().toString() : "Sin calificar");
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public byte[] generarReporteAsistencias(List<Asistencias> asistencias, Usuarios usuario) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Historial de Asistencias - EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Datos del alumno
            documento.add(new Paragraph("Alumno: " + usuario.getNombre() + " " + usuario.getApellido()));
            documento.add(new Paragraph("Correo: " + usuario.getEmail()));
            documento.add(new Paragraph(" ")); // Espacio en blanco

            // Tabla de Asistencias (3 columnas)
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);

            // Encabezados
            String[] encabezados = {"Fecha", "Asignatura", "Grupo"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(173, 216, 230)); // Color azul clarito
                tabla.addCell(celda);
            }

            // Llenar datos (si no tiene asistencias, no entra al for)
            for (Asistencias asis : asistencias) {
                tabla.addCell(asis.getFecha().toString());
                tabla.addCell(asis.getGrupo().getAsignatura().getNombre());
                tabla.addCell(asis.getGrupo().getNombre());
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public byte[] generarReporteGrupos(List<Grupos> grupos) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Reporte de Grupos - Sistema EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Tabla de Grupos (4 columnas)
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1f, 3f, 4f, 4f});

            // Encabezados
            String[] encabezados = {"ID", "Grupo", "Asignatura", "Profesor Titular"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(173, 216, 230)); // Tu color azul clarito
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(5);
                tabla.addCell(celda);
            }

            // Llenar datos de la base de datos
            for (Grupos grupo : grupos) {
                tabla.addCell(String.valueOf(grupo.getId()));
                tabla.addCell(grupo.getNombre());
                tabla.addCell(grupo.getAsignatura().getNombre());

                String nombreProfesor = grupo.getProfesor().getUsuario().getNombre() + " " +
                        grupo.getProfesor().getUsuario().getApellido();
                tabla.addCell(nombreProfesor);
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    public byte[] generarReporteMisGruposProfesor(List<Inscripciones> inscripciones, Usuarios profesor) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Reporte de Grupos Asignados - EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Datos del profesor
            documento.add(new Paragraph("Profesor: " + profesor.getNombre() + " " + (profesor.getApellido() != null ? profesor.getApellido() : "")));
            documento.add(new Paragraph("Correo: " + profesor.getEmail()));
            documento.add(new Paragraph(" ")); // Espacio en blanco

            // Tabla de Grupos (3 columnas)
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{2f, 3f, 4f});

            // Encabezados
            String[] encabezados = {"Grupo", "Asignatura", "Alumno Inscrito"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(173, 216, 230)); // Mismo azul que ya usas
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(5);
                tabla.addCell(celda);
            }

            // Llenar datos iterando sobre las inscripciones del profesor
            for (Inscripciones inscripcion : inscripciones) {
                tabla.addCell(inscripcion.getGrupo().getNombre());
                tabla.addCell(inscripcion.getGrupo().getAsignatura().getNombre());

                String nombreAlumno = inscripcion.getAlumno().getUsuario().getNombre() + " " + inscripcion.getAlumno().getUsuario().getApellido();
                tabla.addCell(nombreAlumno);
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }



}