package com.seekho.api.controller;

import com.seekho.api.dto.ReceiptDTO;
import com.seekho.api.service.ReceiptService;
import com.seekho.api.utility.PdfReceiptGenerator;  // This is our utility class for PDF
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public List<ReceiptDTO> getAll() {
        return receiptService.getAll();
    }

    @GetMapping("/{id}")
    public ReceiptDTO getById(@PathVariable Long id) {
        return receiptService.getById(id);
    }

    @PostMapping
    public ReceiptDTO create(@RequestBody ReceiptDTO dto) {
        return receiptService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        receiptService.delete(id);
    }

    // ✅ New PDF endpoint
    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> generateReceiptPdf(@PathVariable Long id) {
        ReceiptDTO receipt = receiptService.getById(id);

        ByteArrayOutputStream pdfStream = PdfReceiptGenerator.generateReceiptPDF(
                String.valueOf(receipt.getReceipt_id()),
                String.valueOf(receipt.getReceipt_date()),
                receipt.getReceipt_amount(),
                receipt.getPayment_id(),
                String.valueOf("saurabh"),
                Integer.valueOf("544255")
        );

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=receipt_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfStream.toByteArray());
    }
}
