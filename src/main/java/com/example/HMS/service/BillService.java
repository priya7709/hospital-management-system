package com.example.HMS.service;

import com.example.HMS.dao.BillDao;
import com.example.HMS.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillDao billDao;

    public List<Bill> getAllBills() {
        return billDao.findAll();
    }

    public String createBill(Bill bill) {
        billDao.save(bill);
        return "Bill created successfully";
    }

    public Bill getBillById(Long id) {
        Optional<Bill> billOptional = billDao.findById(id);
        if (billOptional.isPresent())
            return billOptional.get();
        return null;
    }

    public void deleteBillById(Long id) {
        billDao.deleteById(id);
        System.out.println(id + " Deleted");
    }

    public Bill updateBill(Long id, Bill updateBill) {
        Optional<Bill> existingBill = billDao.findById(id);
        if (existingBill.isPresent()){
            Bill b = existingBill.get();
            b.setPatient(updateBill.getPatient());
            b.setAmount(updateBill.getAmount());
            b.setStatus(updateBill.getStatus());
            billDao.save(b);
            return updateBill;
        }
        return null;
    }
}
