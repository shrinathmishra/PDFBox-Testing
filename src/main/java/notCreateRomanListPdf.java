import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class notCreateRomanListPdf {
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
//        char listALpha = 'a';
        int listNumber = 1;

        for(String listItem : listItems){
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
//            contentStream.showText(listALpha+". ");
//            contentStream.showText(startListNumber+". ");
            contentStream.showText((intToRoman(listNumber))+". ");

            contentStream.showText(listItem);
            contentStream.newLine();

//            listALpha++;
//            startListNumber++;
            listNumber++;
        }

        contentStream.endText();
        contentStream.close();

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }

    static String intToRoman(int number) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<values.length; i++){
            while(number>=values[i]){
                number -= values[i];
                sb.append(romanLiterals[i]);
            }
        }

        return sb.toString();
    }
}
