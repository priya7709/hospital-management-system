package com.example.HMS.controller;

import com.example.HMS.models.Bill;
import com.example.HMS.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @PostMapping("add")
    public String createBill(@RequestBody Bill bill){
        return billService.createBill(bill);
    }

    @GetMapping("get/{id}")
    public Bill getBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBillById(@PathVariable Long id){
        billService.deleteBillById(id);
    }

    @PutMapping("update/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill updateBill){
        return billService.updateBill(id, updateBill);
    }
}
