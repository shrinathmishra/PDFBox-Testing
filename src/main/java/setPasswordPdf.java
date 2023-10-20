import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.IOException;
import java.util.Calendar;

public class setPasswordPdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);

        PDDocumentInformation docInfo = document.getDocumentInformation();

        docInfo.setAuthor("Shrinath");
        docInfo.setTitle("ABHI");
        docInfo.setCreator("Apache PDFBox");
        docInfo.setSubject("PDFBox Tutorial");
        docInfo.setCreationDate(Calendar.getInstance());
        docInfo.setKeywords("PDFBox, Java PDF, Apache PDF");

        final int KeyLength = 128;
        AccessPermission accessPermission = new AccessPermission();

        accessPermission.setCanPrint(false);
        accessPermission.setCanModify(false);

        StandardProtectionPolicy sp = new StandardProtectionPolicy("1124", "hello", accessPermission);
        sp.setEncryptionKeyLength(KeyLength);
        sp.setPermissions(accessPermission);
        document.protect(sp);

        document.save("C:\\ABHI\\createPDF\\result\\myPDF.pdf");
        document.close();
        System.out.println("PDF Created");
    }
}
