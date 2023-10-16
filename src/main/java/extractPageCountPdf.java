import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class extractPageCountPdf {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        PDDocument document = PDDocument.load(oldFile);

        File newFileDestination = new File("C:\\ABHI\\createPDF\\extract");
        newFileDestination.mkdirs();

        Splitter splitter = new Splitter();
        splitter.setStartPage(2);
        splitter.setEndPage(3);

        List<PDDocument> splitPages = splitter.split(document);

        PDDocument newDoc = new PDDocument();
        for(PDDocument mydoc : splitPages) {
            newDoc.addPage(mydoc.getPage(0));
        }
        newDoc.save(newFileDestination+"\\split.pdf");
        newDoc.close();
        System.out.println("PDF Created");
    }
}
