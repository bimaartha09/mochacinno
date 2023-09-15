package com.ticket.concertticketmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.concertticketmanagement.exception.NotFoundException;
import com.ticket.concertticketmanagement.model.Transaction;
import com.ticket.concertticketmanagement.model.TransactionItem;
import com.ticket.concertticketmanagement.model.constant.TransactionState;
import com.ticket.concertticketmanagement.repository.ConcertCategoryRepository;
import com.ticket.concertticketmanagement.repository.ConcertRepository;
import com.ticket.concertticketmanagement.repository.TransactionItemRepository;
import com.ticket.concertticketmanagement.repository.TransactionRepository;
import com.ticket.concertticketmanagement.request.TransactionItemRequest;
import com.ticket.concertticketmanagement.request.TransactionRequest;
import com.ticket.concertticketmanagement.response.TransactionResponse;
import com.ticket.concertticketmanagement.serializer.TransactionSerializer;

@Service
public class TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  TransactionItemRepository transactionItemRepository;

  @Autowired
  ConcertRepository concertRepository;

  @Autowired
  ConcertCategoryRepository concertCategoryRepository;

  public TransactionResponse createTransaction(TransactionRequest request) {
    Transaction trx = new Transaction();

    int total = calculateTotal(request.getItems());
    int totalPrice = calculateTotalPrice(request.getItems());

    trx.setConcertId(request.getConcertId());
    trx.setState(TransactionState.PENDING);
    trx.setUserId(request.getUserId());
    trx.setTotalPrice(totalPrice);
    trx.setTotal(total);

    transactionRepository.save(trx);

    List<TransactionItem> items = new ArrayList<>();

    for (TransactionItemRequest ti: request.getItems()) {
      TransactionItem item = new TransactionItem();

      item.setTransactionId(trx.getId());
      item.setTotal(ti.getTotal());
      item.setPrice(ti.getPrice());
      item.setConcertCategoryId(ti.getCategoryId());

      items.add(item);
    }

    transactionItemRepository.saveAll(items);

    TransactionSerializer serializer = new TransactionSerializer();
    serializer.setTransaction(trx);
    serializer.setItems(items);

    return serializer.constructResponse();
  }

  public List<TransactionResponse> getAllTransaction(){
    List<Transaction> trxList = transactionRepository.findAll();
    List<TransactionResponse> response = new ArrayList<>();

    for (Transaction trx: trxList) {
      List<TransactionItem> items = transactionItemRepository.findByTransactionId(trx.getId());

      TransactionSerializer serializer = new TransactionSerializer();
      serializer.setTransaction(trx);
      serializer.setItems(items);

      response.add(serializer.constructResponse());
    }

    return response;
  }

  public TransactionResponse getTransactionByID(long transactionId) {
    Transaction trx = transactionRepository.findById(transactionId)
      .orElseThrow(() -> new NotFoundException("transactionId", transactionId));

    List<TransactionItem> items = transactionItemRepository.findByTransactionId(trx.getId());

    TransactionSerializer serializer = new TransactionSerializer();
    serializer.setTransaction(trx);
    serializer.setItems(items);

    return serializer.constructResponse();
  }

  private int calculateTotal(List<TransactionItemRequest> items) {
    int total = 0;

    for (TransactionItemRequest ti: items) {
      total += ti.getTotal();
    }
    return total;
  }

  private int calculateTotalPrice(List<TransactionItemRequest> items) {
    int total = 0;

    for (TransactionItemRequest ti: items) {
      total += ti.getPrice() * ti.getTotal();
    }
    return total;
  }
}
