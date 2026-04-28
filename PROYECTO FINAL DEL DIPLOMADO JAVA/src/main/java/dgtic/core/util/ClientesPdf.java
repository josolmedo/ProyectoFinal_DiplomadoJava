/*package dgtic.core.util;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.model.dto.cliente.ClienteDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Component("clientes/clientes-pdf")
public class ClientesPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        List<ClienteDTO> datos=(List<ClienteDTO>)model.get("datos");
        String ruta=((String)model.get("ruta"));
        String rutaAlm=ruta+"temp.pdf";
        PdfWriter.getInstance(document,new FileOutputStream(rutaAlm));
        document.open();
        PdfPTable tabla=new PdfPTable(4);
        PdfPCell celda=new PdfPCell(new Phrase("Nombre"));
        celda.setBackgroundColor(new Color(167,218,255));
        celda.setPadding(8f);
        tabla.addCell(celda);
        tabla.addCell("Email");
        tabla.addCell("Teléfono");
        tabla.addCell("Ciudad");
        for(ClienteDTO cl:datos){
            tabla.addCell(cl.getNombre());
            tabla.addCell(cl.getEmail());
            tabla.addCell(cl.getTelefono());
            tabla.addCell(cl.getCiudad());
        }
        document.add(tabla);
        document.close();
    }
}*/