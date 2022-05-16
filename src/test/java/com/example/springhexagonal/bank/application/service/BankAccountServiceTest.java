package com.example.springhexagonal.bank.application.service;

import com.example.springhexagonal.bank.application.port.out.LoadAccountPort;
import com.example.springhexagonal.bank.application.port.out.SaveAccountPort;
import com.example.springhexagonal.bank.domain.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BankAccountServiceTest {

    private LoadAccountPort loadAccountPort =
            id -> BankAccount.builder()
                    .id(id)
                    .balance(BigDecimal.valueOf(100))
                    .build();
    private SaveAccountPort saveAccountPort = bankAccount -> {};

    private BankAccountService subject;
    @BeforeEach
    void setUp() {
        subject = new BankAccountService(loadAccountPort, saveAccountPort);
    }

    @Test
    void givenIdAndAmount_whenDeposit_thenReturnAddedAmountBalance() {
        // Given
        Long id = 1L;
        BigDecimal amount = BigDecimal.valueOf(10);

        // When
        BigDecimal balance = subject.deposit(id, amount);

        // Then
        assertThat(balance.intValue()).isEqualTo(110);
    }

    @Test
    void givenIdAndAmount_whenWithDraw_thenAmountSubtractBalance() {
        // Given
        Long id = 1L;
        BigDecimal amount = BigDecimal.valueOf(100);

        // When
        BigDecimal balance = subject.withdraw(id, amount);

        // Then
        assertThat(balance.intValue()).isEqualTo(0);
    }

    @Test
    void givenIdAndAmount_whenWithDraw_thenThrowException() {
        // Given
        Long id = 1L;
        BigDecimal amount = BigDecimal.valueOf(200);

        // When & Then
        assertThatThrownBy(() -> subject.withdraw(id, amount))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("account balance less then amount");
    }
}