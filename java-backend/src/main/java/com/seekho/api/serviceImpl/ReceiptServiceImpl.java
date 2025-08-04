//package com.seekho.api.serviceImpl;
//
//import com.seekho.api.dto.ReceiptDTO;
//import com.seekho.api.entity.Receipt;
//import com.seekho.api.mapper.ReceiptMapper;
//import com.seekho.api.repository.ReceiptRepository;
//import com.seekho.api.service.ReceiptService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class ReceiptServiceImpl implements ReceiptService {
//
//    @Autowired
//    private ReceiptRepository receiptRepository;
//
//    @Override
//    public ReceiptDTO createReceipt(ReceiptDTO dto) {
//        Receipt receipt = ReceiptMapper.toEntity(dto);
//        return ReceiptMapper.toDTO(receiptRepository.save(receipt));
//    }
//
//    @Override
//    public ReceiptDTO getReceiptById(int id) {
//        Optional<Receipt> optional = receiptRepository.findById(id);
//        return optional.map(ReceiptMapper::toDTO).orElse(null);
//    }
//
//    @Override
//    public List<ReceiptDTO> getAllReceipts() {
//        return receiptRepository.findAll()
//                .stream()
//                .map(ReceiptMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ReceiptDTO updateReceipt(int id, ReceiptDTO dto) {
//        Optional<Receipt> optional = receiptRepository.findById(id);
//        if (optional.isPresent()) {
//            Receipt receipt = ReceiptMapper.toEntity(dto);
//            receipt.setReceiptId(id);
//            return ReceiptMapper.toDTO(receiptRepository.save(receipt));
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteReceipt(int id) {
//        receiptRepository.deleteById(id);
//    }
//}


package com.seekho.api.serviceImpl;

import com.seekho.api.dto.ReceiptDTO;
import com.seekho.api.entity.Receipt;
import com.seekho.api.mapper.ReceiptMapper;
import com.seekho.api.repository.ReceiptRepository;
import com.seekho.api.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public List<ReceiptDTO> getAll() {
        return receiptRepository.findAll().stream()
                .map(ReceiptMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDTO getById(Long id) {
        return receiptRepository.findById(id)
                .map(ReceiptMapper::toDTO)
                .orElse(null);
    }

    @Override
    public ReceiptDTO create(ReceiptDTO dto) {
        Receipt entity = ReceiptMapper.toEntity(dto);
        return ReceiptMapper.toDTO(receiptRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        receiptRepository.deleteById(id);
    }
}
