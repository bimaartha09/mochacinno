package com.ticket.concertticketmanagement.request;

import java.util.List;

public class TransactionRequest {
  private Long userId;
  private Long concertId;
  private List<TransactionItemRequest> items;

  public Long getConcertId() {
    return concertId;
  }

  public List<TransactionItemRequest> getItems() {
    return items;
  }

  public Long getUserId() {
    return userId;
  }
}
