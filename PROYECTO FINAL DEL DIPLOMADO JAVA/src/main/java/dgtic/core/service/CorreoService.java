package dgtic.core.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoConPdf(String destinatario, String asunto, String cuerpo, byte[] pdfData, String nombreArchivo) {
        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            // true indica que lleva archivos adjuntos (multipart)
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

            helper.setFrom("joseangelolmedoguevara@gmail.com");
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo);

            // Adjuntar el PDF
            helper.addAttachment(nombreArchivo, new ByteArrayResource(pdfData));

            mailSender.send(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo");
        }
    }
}