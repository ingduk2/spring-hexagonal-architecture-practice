package com.example.springhexagonal.bank.adapter.out.persistence;

import com.example.springhexagonal.bank.adapter.out.persistence.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountSpringDataRepository extends JpaRepository<BankAccountEntity, Long> {
}
