package com.example.springhexagonal.bank.application.port.out;

import com.example.springhexagonal.bank.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
