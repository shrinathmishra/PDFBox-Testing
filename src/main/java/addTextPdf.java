import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class addTextPdf {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        PDPageContentStream contentStream = new PDPageContentStream(document, firstpage);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
        contentStream.setLeading(16.0f);

        contentStream.newLineAtOffset(25, firstpage.getTrimBox().getHeight()-25);

        String text1 = "This is first line";
        String text2 = "This is second line";
        String text3 = "This is third line";

        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText(text3);

        contentStream.endText();
        contentStream.close();

        document.save("C:\\ABHI\\createPDF\\result\\myPDF1.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
