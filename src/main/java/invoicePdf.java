import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class invoicePdf {
    public static void main(String[] args) throws IOException {
        int totalPdfs = 3;

        // Initialize FileWriter to append to the same file
        FileWriter writer = new FileWriter("C:\\ABHI\\createPDF\\result\\invoice\\timestamps\\timestamps_for"+totalPdfs+".txt", true);

        long totalElapsedTime = 0; // Initialize the total elapsed time



        for(int i=1; i<=totalPdfs; i++){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date startTime = new Date();

            PDDocument document = new PDDocument();
            PDPage firstPage = new PDPage(PDRectangle.A4);
            document.addPage(firstPage);

            String name = "Shrinath Mishra";
            String callNo = "+91-7574885947";

            Format d_format = new SimpleDateFormat("dd/MM/yyyy");
            Format t_format = new SimpleDateFormat("HH:mm");

            int pageWidth = (int) firstPage.getTrimBox().getWidth();
            int pageHeight = (int) firstPage.getTrimBox().getHeight();

            PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
            MyTextClass myTextClass = new MyTextClass(document, contentStream);

            PDFont font = PDType1Font.HELVETICA;
            PDFont italicFont = PDType1Font.HELVETICA_OBLIQUE;

            PDImageXObject headImage = PDImageXObject.createFromFile("C:\\ABHI\\createPDF\\PDFBoxTesting\\src\\main\\resources\\img\\IndianTadkaHead.png", document);
            contentStream.drawImage(headImage, 0, pageHeight-235, pageWidth, 239);

            String[] contactDetails = new String[]{"7574885947","9997771888"};
            myTextClass.addMultiLineText(contactDetails, 18, (int)(pageWidth - font.getStringWidth("7574885947")/1000*15-10),
                    pageHeight-25, font, 15, Color.BLACK);

            myTextClass.addSingleLineText("Indian Tadka" , 25, pageHeight-150, font, 40, Color.BLACK);

            myTextClass.addSingleLineText("Customer Name:"+name, 25, pageHeight-250, font, 16, Color.BLACK );
            myTextClass.addSingleLineText("Mo. No: "+callNo, 25, pageHeight-274, font, 16, Color.BLACK);

            String invoiceNo = "Invoice# 2580";
            float textWidth = myTextClass.getTextWidth(invoiceNo,font,16);
            myTextClass.addSingleLineText(invoiceNo, (int) (pageWidth-25-textWidth), pageHeight-250, font, 16, Color.BLACK);

            float dataTextWidth = myTextClass.getTextWidth("Date: " + d_format.format(new Date()), font, 16 );
            myTextClass.addSingleLineText("Date: " + d_format.format(new Date()), (int) (pageWidth-25-dataTextWidth), pageHeight-274, font, 16, Color.BLACK);

            String time = t_format.format(new Date());
            float timeTextWidth = myTextClass.getTextWidth("Time: "+time, font, 16);
            myTextClass.addSingleLineText("Time: "+time, (int) (pageWidth-25-timeTextWidth), pageHeight-298, font,16, Color.BLACK);

            MyTableClass myTable = new MyTableClass(document, contentStream);

            int[] cellWidths = {70, 160, 120, 90, 100};
            myTable.setTable(cellWidths, 30, 25, pageHeight-350);
            myTable.setTableFont(font, 16, Color.BLACK);

            Color tableHeadColor = new Color(240, 93, 11);
            Color tableBodyColor = new Color(219, 218, 198);

            myTable.addCell("Sr. No.", tableHeadColor);
            myTable.addCell("Items", tableHeadColor);
            myTable.addCell("Price", tableHeadColor);
            myTable.addCell("Qty", tableHeadColor);
            myTable.addCell("Total", tableHeadColor);

            myTable.addCell("1.", tableBodyColor);
            myTable.addCell("Masala Dosa", tableBodyColor);
            myTable.addCell("120", tableBodyColor);
            myTable.addCell("2", tableBodyColor);
            myTable.addCell("240", tableBodyColor);

            myTable.addCell("2.", tableBodyColor);
            myTable.addCell("Idli Sambhar", tableBodyColor);
            myTable.addCell("60", tableBodyColor);
            myTable.addCell("4", tableBodyColor);
            myTable.addCell("240", tableBodyColor);

            myTable.addCell("3.", tableBodyColor);
            myTable.addCell("Dhokla", tableBodyColor);
            myTable.addCell("50", tableBodyColor);
            myTable.addCell("4", tableBodyColor);
            myTable.addCell("200", tableBodyColor);

            myTable.addCell("4.", tableBodyColor);
            myTable.addCell("Samosa", tableBodyColor);
            myTable.addCell("20", tableBodyColor);
            myTable.addCell("6", tableBodyColor);
            myTable.addCell("120", tableBodyColor);

            myTable.addCell("", null);
            myTable.addCell("", null);
            myTable.addCell("Sub Total", null);
            myTable.addCell("", null);
            myTable.addCell("880", null);

            myTable.addCell("",    null);
            myTable.addCell("",    null);
            myTable.addCell("GST", null);
            myTable.addCell("5%",  null);
            myTable.addCell("44",  null);

            myTable.addCell("",            null);
            myTable.addCell("",            null);
            myTable.addCell("Grand Total", tableHeadColor);
            myTable.addCell("",            tableHeadColor);
            myTable.addCell("924",         tableHeadColor);

//        Method of Payments
            String[] paymentMethod = {"Methods of Payment we accept: ", "Cash, PhonePe, GPay, RuPay", "Visa, Mastercard and American Express"};
            myTextClass.addMultiLineText(paymentMethod, 15, 25, 180, italicFont, 10, new Color(122, 122, 122));

//        authorized signatory
            contentStream.setStrokingColor(Color.BLACK);
            contentStream.setLineWidth(2);
            contentStream.moveTo(pageWidth-250, 150);
            contentStream.lineTo(pageWidth-25, 150);
            contentStream.stroke();

            String authoSign = "Authorised Signatory";
            float authoSignWidth = myTextClass.getTextWidth(authoSign, italicFont, 16);
            int xpos = pageWidth-250+pageWidth-25;
            myTextClass.addSingleLineText(authoSign, (int)(xpos-authoSignWidth)/2, 125, italicFont, 16, Color.BLACK);

            String bottomLine = "Rain or Shine, it's time to dine";
            float bottomLineWidth = myTextClass.getTextWidth(bottomLine, font, 20);
            myTextClass.addSingleLineText(bottomLine, (int)(pageWidth-bottomLineWidth)/2, 50, italicFont,20, Color.DARK_GRAY);

            Color bottomRectColor = new Color(255, 91, 0);
            contentStream.setNonStrokingColor(bottomRectColor);
            contentStream.addRect(0,0, pageWidth, 30);
            contentStream.fill();

            contentStream.close();
            document.save("C:\\ABHI\\createPDF\\result\\invoice\\invoice"+i+".pdf");
            document.close();
            Date endTime = new Date();

            System.out.println("PDF Created "+i);

            // Calculate the elapsed time
            long elapsedTime = endTime.getTime() - startTime.getTime();

            // Add the elapsed time for this iteration to the total elapsed time
            totalElapsedTime += elapsedTime;

            // Log the timestamps to the same file
            String log = i + " Start Time: " + dateFormat.format(startTime) + "\n" +
                    " End Time: " + dateFormat.format(endTime) + "\n" +
                    " Elapsed Time (ms): " + elapsedTime + "\n\n";

            // Append the log to the file
            writer.write(log);
            writer.flush(); // Ensure the data is written immediately

        }

        // Log the total elapsed time after the loop
        String totalLog = "\n\nTotal Elapsed Time (ms): " + totalElapsedTime + "\n";
        writer.write(totalLog);
        writer.flush();

        // Close the FileWriter when you're done with it
        writer.close();

    }

    private static class MyTextClass{
        PDDocument document;
        PDPageContentStream contentStream;

        public MyTextClass(PDDocument document, PDPageContentStream contentStream) {
            this.document = document;
            this.contentStream = contentStream;
        }

        void addSingleLineText(String text, int xPosition, int yPosition, PDFont font, float fontSize, Color color) throws IOException {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.setNonStrokingColor(color);
            contentStream.newLineAtOffset(xPosition, yPosition);
            contentStream.showText(text);
            contentStream.endText();
            contentStream.moveTo(0,0);
        }

        void addMultiLineText(String[] textArray, float leading, int xPosition, int yPosition, PDFont font, float fontSize, Color color) throws IOException {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.setNonStrokingColor(color);
            contentStream.setLeading(leading);
            contentStream.newLineAtOffset(xPosition, yPosition);

            for(String text : textArray){
                contentStream.showText(text);
                contentStream.newLine();
            }
            contentStream.endText();
            contentStream.moveTo(0,0);
        }

        float getTextWidth(String text, PDFont font, float fontSize) throws IOException {
            return font.getStringWidth(text)/1000 * fontSize;
        }
    }

    private static class MyTableClass{

        PDDocument document;
        PDPageContentStream contentStream;
        private int[] colWidths;
        private int cellHeight;
        private int yPosition;
        private int xPosition;
        private int colPosition;
        private int xInitialPosition;
        private float fontSize;
        private PDFont font;
        private Color fontColor;

        public MyTableClass(PDDocument document, PDPageContentStream contentStream){
            this.document = document;
            this.contentStream = contentStream;
        }

        void setTable(int[] colWidths, int cellHeight, int xPosition, int yPosition ){
            this.colWidths = colWidths;
            this.cellHeight = cellHeight;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            xInitialPosition = xPosition;
        }

        void setTableFont(PDFont font, float fontSize, Color fontColor){
            this.font = font;
            this.fontSize = fontSize;
            this.fontColor = fontColor;
        }

        void addCell(String text, Color fillColor) throws IOException {
            contentStream.setStrokingColor(1f);

            if(fillColor != null){
                contentStream.setNonStrokingColor(fillColor);
            }

            contentStream.addRect(xPosition, yPosition, colWidths[colPosition], cellHeight);

            if(fillColor == null)
                contentStream.stroke();
            else
                contentStream.fillAndStroke();

            contentStream.beginText();
            contentStream.setNonStrokingColor(fontColor);

            if(colPosition == 4 || colPosition == 2){
                float fontWidth = font.getStringWidth(text)/1000 * fontSize;
                contentStream.newLineAtOffset(xPosition+colWidths[colPosition]-20-fontWidth, yPosition+10);
            }
            else{
                contentStream.newLineAtOffset(xPosition+20, yPosition+10);
            }

            contentStream.showText(text);
            contentStream.endText();

            xPosition = xPosition + colWidths[colPosition];
            colPosition++;

            if(colPosition == colWidths.length){
                colPosition = 0;
                xPosition = xInitialPosition;
                yPosition -= cellHeight;
            }
        }
    }
}
