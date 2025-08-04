//package com.seekho.api.service;
//
//import com.seekho.api.dto.PaymentDTO;
//
//import java.util.List;
//
//public interface PaymentService {
//
//    PaymentDTO createPayment(PaymentDTO paymentDTO);
//
//    PaymentDTO getPaymentById(int paymentId);
//
//    List<PaymentDTO> getAllPayments();
//
//    PaymentDTO updatePayment(int paymentId, PaymentDTO paymentDTO);
//
//    void deletePayment(int paymentId);
//}


package com.seekho.api.service;

import com.seekho.api.dto.PaymentDTO;
import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAll();
    PaymentDTO getById(Long id);
    PaymentDTO create(PaymentDTO dto);
    void delete(Long id);
}
