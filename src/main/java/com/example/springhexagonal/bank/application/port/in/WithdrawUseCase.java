package com.example.springhexagonal.bank.application.port.in;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    BigDecimal withdraw(Long id, BigDecimal amount);
}
