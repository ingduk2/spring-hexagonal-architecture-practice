package com.example.springhexagonal.bank.application.port.out;

import com.example.springhexagonal.bank.domain.BankAccount;

public interface LoadAccountPort {
    BankAccount load(Long id);
}
