//package com.seekho.api.service;
//
//import com.seekho.api.dto.ReceiptDTO;
//
//import java.util.List;
//
//public interface ReceiptService {
//
//    ReceiptDTO createReceipt(ReceiptDTO receiptDTO);
//
//    ReceiptDTO getReceiptById(int receiptId);
//
//    List<ReceiptDTO> getAllReceipts();
//
//    ReceiptDTO updateReceipt(int receiptId, ReceiptDTO receiptDTO);
//
//    void deleteReceipt(int receiptId);
//}


package com.seekho.api.service;

import com.seekho.api.dto.ReceiptDTO;
import java.util.List;

public interface ReceiptService {
    List<ReceiptDTO> getAll();
    ReceiptDTO getById(Long id);
    ReceiptDTO create(ReceiptDTO dto);
    void delete(Long id);
}
