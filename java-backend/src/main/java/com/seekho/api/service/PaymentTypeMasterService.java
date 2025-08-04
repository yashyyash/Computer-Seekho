//package com.seekho.api.service;
//
//import com.seekho.api.dto.PaymentTypeMasterDTO;
//
//import java.util.List;
//
//public interface PaymentTypeMasterService {
//
//    PaymentTypeMasterDTO createPaymentType(PaymentTypeMasterDTO dto);
//
//    PaymentTypeMasterDTO getPaymentTypeById(int id);
//
//    List<PaymentTypeMasterDTO> getAllPaymentTypes();
//
//    PaymentTypeMasterDTO updatePaymentType(int id, PaymentTypeMasterDTO dto);
//
//    void deletePaymentType(int id);
//}


package com.seekho.api.service;

import com.seekho.api.dto.PaymentTypeMasterDTO;
import java.util.List;

public interface PaymentTypeMasterService {
    List<PaymentTypeMasterDTO> getAll();
    PaymentTypeMasterDTO getById(Long id);
    PaymentTypeMasterDTO create(PaymentTypeMasterDTO dto);
    void delete(Long id);
}
