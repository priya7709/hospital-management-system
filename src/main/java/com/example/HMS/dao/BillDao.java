package com.example.HMS.dao;

import com.example.HMS.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDao extends JpaRepository<Bill, Long> {
}
