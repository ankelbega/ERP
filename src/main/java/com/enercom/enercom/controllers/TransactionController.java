package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Transaction;
import com.enercom.enercom.services.transaction.SaveTransactionRequest;
import com.enercom.enercom.services.transaction.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable int id) {
        var item = this.transactionService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveTransactionRequest request) {
        return transactionService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        transactionService.delete(id);
    }
}
