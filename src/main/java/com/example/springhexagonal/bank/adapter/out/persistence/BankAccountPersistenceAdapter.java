package com.example.springhexagonal.bank.adapter.out.persistence;

import com.example.springhexagonal.bank.application.port.out.LoadAccountPort;
import com.example.springhexagonal.bank.application.port.out.SaveAccountPort;
import com.example.springhexagonal.bank.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountSpringDataRepository repository;

    @Override
    public BankAccount load(Long id) {
        BankAccountEntity entity = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        return bankAccountMapper.toDomain(entity);
    }

    @Override
    public void save(BankAccount bankAccount) {
        BankAccountEntity entity= bankAccountMapper.toEntity(bankAccount);
        repository.save(entity);
    }
}
