package com.enercom.enercom.services.transaction;

import com.enercom.enercom.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> findAll();

    Optional<Transaction> findById(int id);

    int save(SaveTransactionRequest request);

    void delete(int id);
}
