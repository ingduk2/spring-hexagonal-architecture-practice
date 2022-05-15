package com.example.springhexagonal.bank.adapter.out.persistence;

import com.example.springhexagonal.bank.adapter.out.persistence.BankAccountEntity;
import com.example.springhexagonal.bank.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount toDomain(BankAccountEntity entity) {
        return BankAccount.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .build();
    }

    public BankAccountEntity toEntity(BankAccount domain) {
        return BankAccountEntity.builder()
                .balance(domain.getBalance())
                .build();
    }
}
