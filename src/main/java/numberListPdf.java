import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class numberListPdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        File myBulletFont1 = new File("C:\\ABHI\\createPDF\\PDFBoxTesting\\src\\main\\resources\\fonts\\PierreDingbats.ttf");
        PDFont bulletFont1 = PDType0Font.load(document, myBulletFont1);

        PDPageContentStream.AppendMode appendContent;
        PDPageContentStream contentStream = new PDPageContentStream(document, firstpage);
        contentStream.beginText();
        contentStream.setLeading(25.0f);

        contentStream.newLineAtOffset(50, firstpage.getTrimBox().getHeight()-50);

        String[] listItems = new String[]{
                "This is list item 1",
                "This is list item 2",
                "This is list item 3",
                "This is list item 4",
                "This is list item 5",
                "This is list item 6",
                "This is list item 7",
                "This is list item 8",
        };

//        int startListNumber = 1;
        char listALpha = 'a';

        for(String listItem : listItems){
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
            contentStream.showText(listALpha+". ");
            //contentStream.showText(startListNumber+". ");


            contentStream.showText(listItem);
            contentStream.newLine();

            listALpha++;
            //startListNumber++;
        }

        contentStream.endText();
        contentStream.close();

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
