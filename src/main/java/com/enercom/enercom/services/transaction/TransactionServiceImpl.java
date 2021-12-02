package com.enercom.enercom.services.transaction;

import com.enercom.enercom.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import com.enercom.enercom.domain.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<com.enercom.enercom.domain.Transaction> findById(int id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = transactionRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        transactionRepository.delete(item);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public int save(SaveTransactionRequest request) {
        var dbItem = transactionRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setCode(request.getCode());
            dbItem.get().setState(request.getState());
            transactionRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Transaction.builder()
                .code(request.getCode())
                .state(request.getState())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        transactionRepository.save(newItem);
        return newItem.getId();
    }
}
