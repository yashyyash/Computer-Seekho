//package com.seekho.api.serviceImpl;
//
//import com.seekho.api.dto.PaymentTypeMasterDTO;
//import com.seekho.api.entity.PaymentTypeMaster;
//import com.seekho.api.mapper.PaymentTypeMasterMapper;
//import com.seekho.api.repository.PaymentTypeMasterRepository;
//import com.seekho.api.service.PaymentTypeMasterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PaymentTypeMasterServiceImpl implements PaymentTypeMasterService {
//
//    @Autowired
//    private PaymentTypeMasterRepository repository;
//
//    @Override
//    public PaymentTypeMasterDTO createPaymentType(PaymentTypeMasterDTO dto) {
//        PaymentTypeMaster entity = PaymentTypeMasterMapper.toEntity(dto);
//        return PaymentTypeMasterMapper.toDTO(repository.save(entity));
//    }
//
//    @Override
//    public PaymentTypeMasterDTO getPaymentTypeById(int id) {
//        Optional<PaymentTypeMaster> optional = repository.findById(id);
//        return optional.map(PaymentTypeMasterMapper::toDTO).orElse(null);
//    }
//
//    @Override
//    public List<PaymentTypeMasterDTO> getAllPaymentTypes() {
//        return repository.findAll()
//                .stream()
//                .map(PaymentTypeMasterMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public PaymentTypeMasterDTO updatePaymentType(int id, PaymentTypeMasterDTO dto) {
//        Optional<PaymentTypeMaster> optional = repository.findById(id);
//        if (optional.isPresent()) {
//            PaymentTypeMaster entity = PaymentTypeMasterMapper.toEntity(dto);
//            entity.setPaymentTypeId(id);
//            return PaymentTypeMasterMapper.toDTO(repository.save(entity));
//        }
//        return null;
//    }
//
//    @Override
//    public void deletePaymentType(int id) {
//        repository.deleteById(id);
//    }
//}


package com.seekho.api.serviceImpl;

import com.seekho.api.dto.PaymentTypeMasterDTO;
import com.seekho.api.entity.PaymentTypeMaster;
import com.seekho.api.mapper.PaymentTypeMasterMapper;
import com.seekho.api.repository.PaymentTypeMasterRepository;
import com.seekho.api.service.PaymentTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTypeMasterServiceImpl implements PaymentTypeMasterService {

    @Autowired
    private PaymentTypeMasterRepository repository;

    @Override
    public List<PaymentTypeMasterDTO> getAll() {
        return repository.findAll().stream()
                .map(PaymentTypeMasterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentTypeMasterDTO getById(Long id) {
        return repository.findById(id)
                .map(PaymentTypeMasterMapper::toDTO)
                .orElse(null);
    }

    @Override
    public PaymentTypeMasterDTO create(PaymentTypeMasterDTO dto) {
        PaymentTypeMaster entity = PaymentTypeMasterMapper.toEntity(dto);
        return PaymentTypeMasterMapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
