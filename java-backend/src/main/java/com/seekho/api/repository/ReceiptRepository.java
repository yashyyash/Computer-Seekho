//package com.seekho.api.repository;
//
//import com.seekho.api.entity.Receipt;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
//    // Optional: List<Receipt> findByPayment_PaymentId(int paymentId);
//}
//


package com.seekho.api.repository;

import com.seekho.api.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
