package GerarPDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Busca.APP;

public class GerarPdf {


    public static void main(String[] args) throws ParseException, IOException {
        Document document = null;


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Object data = sdf.format(new Date());

        try {
            document = new Document(
                    PageSize.A4, 50, 50, 50, 50);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ResultadoBusca"+data + ".pdf"));

            document.open();
            Font f = new Font(com.itextpdf.text.Font.FontFamily.COURIER, 20, Font.BOLD);
            Paragraph p = new Paragraph("Resultado da Busca");
            document.add(p);


        } catch (DocumentException e) {
            e.printStackTrace();

        } finally {
            if (document != null) {
                document.close();
            }

        }


    }
}
