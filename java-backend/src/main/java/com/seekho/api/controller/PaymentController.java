//package com.seekho.api.controller;
//
//import com.seekho.api.dto.PaymentDTO;
//import com.seekho.api.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping
//    public PaymentDTO createPayment(@RequestBody PaymentDTO dto) {
//        return paymentService.createPayment(dto);
//    }
//
//    @GetMapping("/{id}")
//    public PaymentDTO getPaymentById(@PathVariable int id) {
//        return paymentService.getPaymentById(id);
//    }
//
//    @GetMapping
//    public List<PaymentDTO> getAllPayments() {
//        return paymentService.getAllPayments();
//    }
//
//    @PutMapping("/{id}")
//    public PaymentDTO updatePayment(@PathVariable int id, @RequestBody PaymentDTO dto) {
//        return paymentService.updatePayment(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePayment(@PathVariable int id) {
//        paymentService.deletePayment(id);
//    }
//}



package com.seekho.api.controller;

import com.seekho.api.dto.PaymentDTO;
import com.seekho.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public PaymentDTO getById(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    @PostMapping
    public PaymentDTO create(@RequestBody PaymentDTO dto) {
        return paymentService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
