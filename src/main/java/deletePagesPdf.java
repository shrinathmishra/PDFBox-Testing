import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class deletePagesPdf {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        PDDocument document = PDDocument.load(oldFile);

        int PageRangeStart = 1;
        int PageRangeEnd = 2;

        for(int i = PageRangeEnd; i>=PageRangeStart; i--){
            document.removePage(i);
        }

        document.save("C:\\ABHI\\createPDF\\result\\rangedeleted.pdf");
        System.out.println("Range of Pages Deleted !");
    }
}
