import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class addImagePdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        PDImageXObject image1 = PDImageXObject.createFromFile("C:\\ABHI\\createPDF\\image.jpeg", document);
        PDPageContentStream contentStream = new PDPageContentStream(document, firstpage);
        contentStream.drawImage(image1, 25,25, 320, 212 );
        contentStream.close();

        document.save("C:\\ABHI\\createPDF\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
