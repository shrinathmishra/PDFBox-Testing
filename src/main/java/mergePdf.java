import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class mergePdf {
    public static void main(String[] args) throws IOException {
        File oldFile1 = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf-modified.pdf");
        File oldFile2 = new File("C:\\ABHI\\createPDF\\Shri_BRC-BDTS.pdf");

        File newFile = new File("C:\\ABHI\\createPDF\\result");
        newFile.mkdirs();

        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.setDestinationFileName(newFile+"\\newFile.pdf");

        pdfMergerUtility.addSource(oldFile1);
        pdfMergerUtility.addSource(oldFile2);

        pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        System.out.println("PDF Created");
    }
}
