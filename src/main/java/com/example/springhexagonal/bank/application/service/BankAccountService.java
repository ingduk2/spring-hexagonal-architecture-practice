package com.example.springhexagonal.bank.application.service;

import com.example.springhexagonal.bank.application.port.in.DepositUseCase;
import com.example.springhexagonal.bank.application.port.out.LoadAccountPort;
import com.example.springhexagonal.bank.application.port.out.SaveAccountPort;
import com.example.springhexagonal.bank.application.port.in.WithdrawUseCase;
import com.example.springhexagonal.bank.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public BigDecimal deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id);

        account.deposit(amount);

        saveAccountPort.save(account);
        return account.getBalance();
    }

    @Override
    public BigDecimal withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id);

        if (account.withdraw(amount)) {
            saveAccountPort.save(account);
        } else {
            throw new RuntimeException("account balance less then amount");
        }

        return account.getBalance();
    }
}
