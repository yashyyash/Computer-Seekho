//package com.seekho.api.serviceImpl;
//
//import com.seekho.api.dto.PaymentDTO;
//import com.seekho.api.entity.Payment;
//import com.seekho.api.mapper.PaymentMapper;
//import com.seekho.api.repository.PaymentRepository;
//import com.seekho.api.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Override
//    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
//        Payment payment = PaymentMapper.toEntity(paymentDTO);
//        return PaymentMapper.toDTO(paymentRepository.save(payment));
//    }
//
//    @Override
//    public PaymentDTO getPaymentById(int paymentId) {
//        Optional<Payment> optional = paymentRepository.findById(paymentId);
//        return optional.map(PaymentMapper::toDTO).orElse(null);
//    }
//
//    @Override
//    public List<PaymentDTO> getAllPayments() {
//        return paymentRepository.findAll()
//                .stream()
//                .map(PaymentMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public PaymentDTO updatePayment(int paymentId, PaymentDTO paymentDTO) {
//        Optional<Payment> optional = paymentRepository.findById(paymentId);
//        if (optional.isPresent()) {
//            Payment payment = PaymentMapper.toEntity(paymentDTO);
//            payment.setPaymentId(paymentId);
//            return PaymentMapper.toDTO(paymentRepository.save(payment));
//        }
//        return null;
//    }
//
//    @Override
//    public void deletePayment(int paymentId) {
//        paymentRepository.deleteById(paymentId);
//    }
//}


package com.seekho.api.serviceImpl;

import com.seekho.api.dto.PaymentDTO;
import com.seekho.api.entity.Payment;
import com.seekho.api.mapper.PaymentMapper;
import com.seekho.api.repository.PaymentRepository;
import com.seekho.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> getAll() {
        return paymentRepository.findAll().stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO getById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDTO)
                .orElse(null);
    }

    @Override
    public PaymentDTO create(PaymentDTO dto) {
        Payment entity = PaymentMapper.toEntity(dto);
        return PaymentMapper.toDTO(paymentRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
