//package com.seekho.api.repository;
//
//import com.seekho.api.entity.PaymentTypeMaster;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PaymentTypeMasterRepository extends JpaRepository<PaymentTypeMaster, Integer> {
//    // Optional: PaymentTypeMaster findByPayment_type_desc(String desc);
//}
//


package com.seekho.api.repository;

import com.seekho.api.entity.PaymentTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeMasterRepository extends JpaRepository<PaymentTypeMaster, Long> {
}
