package com.example.springhexagonal.bank.application.port.in;

import java.math.BigDecimal;

public interface DepositUseCase {
    BigDecimal deposit(Long id, BigDecimal amount);
}
