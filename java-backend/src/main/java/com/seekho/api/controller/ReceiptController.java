//package com.seekho.api.controller;
//
//import com.seekho.api.dto.ReceiptDTO;
//import com.seekho.api.service.ReceiptService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/receipts")
//public class ReceiptController {
//
//    @Autowired
//    private ReceiptService receiptService;
//
//    @PostMapping
//    public ReceiptDTO createReceipt(@RequestBody ReceiptDTO dto) {
//        return receiptService.createReceipt(dto);
//    }
//
//    @GetMapping("/{id}")
//    public ReceiptDTO getReceiptById(@PathVariable int id) {
//        return receiptService.getReceiptById(id);
//    }
//
//    @GetMapping
//    public List<ReceiptDTO> getAllReceipts() {
//        return receiptService.getAllReceipts();
//    }
//
//    @PutMapping("/{id}")
//    public ReceiptDTO updateReceipt(@PathVariable int id, @RequestBody ReceiptDTO dto) {
//        return receiptService.updateReceipt(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteReceipt(@PathVariable int id) {
//        receiptService.deleteReceipt(id);
//    }
//}


package com.seekho.api.controller;

import com.seekho.api.dto.ReceiptDTO;
import com.seekho.api.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
