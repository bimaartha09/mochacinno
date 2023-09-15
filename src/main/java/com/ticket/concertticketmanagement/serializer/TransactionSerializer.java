package com.ticket.concertticketmanagement.serializer;

import java.util.ArrayList;
import java.util.List;

import com.ticket.concertticketmanagement.model.Transaction;
import com.ticket.concertticketmanagement.model.TransactionItem;
import com.ticket.concertticketmanagement.response.TransactionItemResponse;
import com.ticket.concertticketmanagement.response.TransactionResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TransactionSerializer {

  private Transaction transaction;
  private List<TransactionItem> items;

  public TransactionResponse constructResponse() {
    TransactionResponse response = new TransactionResponse();

    response.setId(transaction.getId());
    response.setConcertId(transaction.getConcertId());
    response.setState(transaction.getState().getCode());
    response.setTotal(transaction.getTotal());
    response.setTotalPrice(transaction.getTotalPrice());
    response.setCreatedAt(transaction.getCreatedAt().toString());
    response.setUpdatedAt(transaction.getUpdatedAt().toString());
    response.setUserId(transaction.getUserId());

    List<TransactionItemResponse> itemResponseList = new ArrayList<>();

    for (TransactionItem it: items) {
      TransactionItemResponse item = new TransactionItemResponse();

      item.setId(it.getId());
      item.setCategory(it.getConcertCategoryId()); // TO DO : improve to return as string
      item.setTransactionId(it.getTransactionId());
      item.setTotal(it.getTotal());
      item.setPrice(it.getPrice());
      item.setCreatedAt(it.getCreatedAt().toString());
      item.setUpdatedAt(it.getUpdatedAt().toString());

      itemResponseList.add(item);
    }

    response.setItems(itemResponseList);

    return response;
  }

}
