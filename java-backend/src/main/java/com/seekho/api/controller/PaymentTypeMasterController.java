//package com.seekho.api.controller;
//
//import com.seekho.api.dto.PaymentTypeMasterDTO;
//import com.seekho.api.service.PaymentTypeMasterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/payment-types")
//public class PaymentTypeMasterController {
//
//    @Autowired
//    private PaymentTypeMasterService service;
//
//    @PostMapping
//    public PaymentTypeMasterDTO createPaymentType(@RequestBody PaymentTypeMasterDTO dto) {
//        return service.createPaymentType(dto);
//    }
//
//    @GetMapping("/{id}")
//    public PaymentTypeMasterDTO getPaymentTypeById(@PathVariable int id) {
//        return service.getPaymentTypeById(id);
//    }
//
//    @GetMapping
//    public List<PaymentTypeMasterDTO> getAllPaymentTypes() {
//        return service.getAllPaymentTypes();
//    }
//
//    @PutMapping("/{id}")
//    public PaymentTypeMasterDTO updatePaymentType(@PathVariable int id, @RequestBody PaymentTypeMasterDTO dto) {
//        return service.updatePaymentType(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePaymentType(@PathVariable int id) {
//        service.deletePaymentType(id);
//    }
//}



package com.seekho.api.controller;

import com.seekho.api.dto.PaymentTypeMasterDTO;
import com.seekho.api.service.PaymentTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-type-master")
public class PaymentTypeMasterController {

    @Autowired
    private PaymentTypeMasterService service;

    @GetMapping
    public List<PaymentTypeMasterDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PaymentTypeMasterDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PaymentTypeMasterDTO create(@RequestBody PaymentTypeMasterDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
