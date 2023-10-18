import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
public class ModifyPdf {
    public static void main(String[] args) throws IOException {
        File oldfile = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf");
        PDDocument document = PDDocument.load(oldfile);
        document.addPage(new PDPage());

        document.save("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        System.out.println("PDF File Modified");
        document.close();
    }
}
