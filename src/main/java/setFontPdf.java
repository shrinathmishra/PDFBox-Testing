import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

public class setFontPdf {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        File myFont1 = new File("C:\\ABHI\\createPDF\\AttackGraffiti.ttf");
        File myFont2 = new File("C:\\ABHI\\createPDF\\ReallyFree.ttf");

        PDFont font1 = PDType0Font.load(document, myFont1);
        PDFont font2 = PDType0Font.load(document, myFont2);

        PDPageContentStream contentStream = new PDPageContentStream(document, firstpage);
        contentStream.beginText();
        contentStream.setLeading(25.0f);

        contentStream.newLineAtOffset(50, firstpage.getTrimBox().getHeight()-50);
        String text1 = "This is text 1";
        String text2 = "This is text 2";

        contentStream.setFont(font1, 18);
        contentStream.showText(text1);
        contentStream.newLine();

        contentStream.setFont(font2, 24);
        contentStream.showText(text2);

        contentStream.endText();
        contentStream.close();

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");

    }
}
