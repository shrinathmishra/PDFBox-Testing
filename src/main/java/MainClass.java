import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        document.save("C:\\ABHI\\createPDF\\myPDF.pdf");
        System.out.println("PDF Created");
        document.close();
    }
}
