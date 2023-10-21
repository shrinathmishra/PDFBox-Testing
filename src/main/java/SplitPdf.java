import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SplitPdf {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        PDDocument document = PDDocument.load(oldFile);

        Splitter splitter = new Splitter();

        List<PDDocument> splitpages = splitter.split(document);

        int num = 1;
        for(PDDocument mydoc : splitpages){
            mydoc.save("C:\\ABHI\\createPDF\\extract\\split0"+num+".pdf");
            num++;
            mydoc.close();
        }
        System.out.println("Split Done");
    }
}
