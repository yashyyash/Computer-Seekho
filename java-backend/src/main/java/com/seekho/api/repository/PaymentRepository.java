//package com.seekho.api.repository;
//
//import com.seekho.api.entity.Payment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PaymentRepository extends JpaRepository<Payment, Integer> {
//    // Add custom queries if needed, e.g.
//    // List<Payment> findByStudentId(int studentId);
//}


package com.seekho.api.repository;

import com.seekho.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
