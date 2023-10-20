import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class setPageSizePdf {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDRectangle myPageSize = new PDRectangle(600, 900);
        PDPage myPage = new PDPage(myPageSize);
        document.addPage(myPage);

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
