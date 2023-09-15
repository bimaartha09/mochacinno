package com.ticket.concertticketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.concertticketmanagement.request.TransactionRequest;
import com.ticket.concertticketmanagement.response.TransactionResponse;
import com.ticket.concertticketmanagement.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @GetMapping("/transactions")
  public List<TransactionResponse> getAllTransactions() {
    return transactionService.getAllTransaction();
  }

  @GetMapping("/transactions/{id}")
  public TransactionResponse getTransactionByID(@PathVariable(value = "id") Long transactionId) {
    return null;
  }

  @PostMapping("/transactions")
  public TransactionResponse createTransaction(@Validated @RequestBody TransactionRequest request){
    return transactionService.createTransaction(request);
  }

}
