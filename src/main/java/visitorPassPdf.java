import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;

public class visitorPassPdf {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDRectangle myPageSize = new PDRectangle(600, 900);
        PDPage myPage = new PDPage(myPageSize);
        document.addPage(myPage);

        String[] visitorDetails = {"Shrinath Mishra", "22", "Mumbai", "9:00 AM to 4:00 PM"};
        int pageWidth = (int) myPage.getTrimBox().getWidth();
        int pageHeight = (int) myPage.getTrimBox().getHeight();

        PDFont font = PDType1Font.HELVETICA_BOLD;

        PDPageContentStream contentStream = new PDPageContentStream(document, myPage);

//        for background image ------------------
        PDImageXObject backgroundImage = PDImageXObject.createFromFile("src\\main\\resources\\img\\background.jpg", document);
        contentStream.drawImage(backgroundImage, 0, 0);

//        for Blue rect ----------------
        contentStream.setNonStrokingColor(new Color(0, 191,243));
        contentStream.addRect(0, pageHeight-90, pageWidth, 90);
        contentStream.fill();

//        for bird img------------
//        PDImageXObject birdImage = PDImageXObject.createFromFile("", document);
//        contentStream.drawImage(birdImage, 0, pageHeight - 268);

//        for line below bird image-------
        contentStream.setNonStrokingColor(new Color(46, 49, 146));
        contentStream.addRect(0,pageHeight-278, pageWidth, 10);
        contentStream.fill();

//        for bottom rect
        contentStream.setNonStrokingColor(new Color(28,187,180));
        contentStream.addRect(0, 0, pageWidth, 60);
        contentStream.fill();

//        for deer image-----------
        PDImageXObject deerImage = PDImageXObject.createFromFile("", document);
        contentStream.drawImage(deerImage, 10, 60, 171, 208);

//        for tiger image -------------
        PDImageXObject tigerImage = PDImageXObject.createFromFile("", document);
        contentStream.drawImage(tigerImage, 270, 62, 314, 146);

//        CORBETT NATIONAL PARK
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.WHITE);
        String text1 = "CORBETT NATIONAL PARK";
        float fontwidth1 = font.getStringWidth(text1) / 1000*40;
        contentStream.newLineAtOffset((pageWidth-fontwidth1)/2, pageHeight-55);
        contentStream.showText(text1);
        contentStream.endText();

//        VISITOR PASS
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.WHITE);
        String text2 = "CORBETT NATIONAL PARK";
        float fontwidth2 = font.getStringWidth(text2) / 1000*40;
        contentStream.newLineAtOffset((pageWidth-fontwidth2)/2, pageHeight-330);
        contentStream.showText(text2);
        contentStream.endText();


//        Details Head -------------
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setLeading(45);
        contentStream.newLineAtOffset(70, pageHeight-400);

        String[] detailsHeadarray = {"Name", "Age", "City", "Date", "Time"};
        for(String detailHead : detailsHeadarray){
            contentStream.showText(detailHead);
            contentStream.newLine();
        }
        contentStream.endText();

//        VISITOR Details -------------------
        contentStream.beginText();
        contentStream.setFont(font, 30);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setLeading(45);
        contentStream.newLineAtOffset(200, pageHeight-400);
        for(String visitorDetail : visitorDetails){
            contentStream.showText(":   "+visitorDetail);
            contentStream.newLine();
        }
        contentStream.endText();

//        Stay away from wildlife -------------
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.WHITE);
        String textWildLife = "CORBETT NATIONAL PARK";
        float fontWildLife = font.getStringWidth(textWildLife) / 1000*40;
        contentStream.newLineAtOffset((pageWidth-fontWildLife)/2, 20);
        contentStream.showText(textWildLife);
        contentStream.endText();

        contentStream.close();
        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
