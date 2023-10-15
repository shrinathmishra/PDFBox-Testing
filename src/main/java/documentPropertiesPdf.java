import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Calendar;

public class documentPropertiesPdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        PDDocumentInformation docInfo = document.getDocumentInformation();

        docInfo.setAuthor("Shrinath");
        docInfo.setTitle("ABHI");
        docInfo.setCreator("Apache PDFBox");
        docInfo.setSubject("PDFBox Tutorial");
        docInfo.setCreationDate(Calendar.getInstance());
        docInfo.setKeywords("PDFBox, Java PDF, Apache PDF");

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
