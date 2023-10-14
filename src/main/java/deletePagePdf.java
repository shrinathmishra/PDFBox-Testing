import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class deletePagePdf {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        PDDocument document = PDDocument.load(oldFile);

        document.removePage(0);
        document.save("C:\\ABHI\\createPDF\\result\\deleted.pdf");
        System.out.println("Page deleted !");
    }
}
