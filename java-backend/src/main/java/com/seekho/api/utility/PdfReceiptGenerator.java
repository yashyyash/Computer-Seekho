package com.seekho.api.utility;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

public class PdfReceiptGenerator {

    public static ByteArrayOutputStream generateReceiptPDF(
            String receiptId,
            String date,
            double amount,
            Long paymentId,
            String studentName,
            int studentRollNo
    ) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            document.add(new Paragraph("Receipt", titleFont));
            document.add(new Paragraph(" ", normalFont));
            document.add(new Paragraph("Receipt ID: " + receiptId, normalFont));
            document.add(new Paragraph("Date: " + date, normalFont));
            document.add(new Paragraph("Student Name: " + studentName, normalFont));
            document.add(new Paragraph("Student Roll No: " + studentRollNo, normalFont));
            document.add(new Paragraph("Payment ID: " + paymentId, normalFont));
            document.add(new Paragraph("Amount Paid: ₹" + amount, normalFont));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }

}
