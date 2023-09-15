package com.ticket.concertticketmanagement.request;

public class TransactionItemRequest {
  private long categoryId;
  private int total;
  private int price;

  public int getTotal() {
    return total;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public int getPrice() {
    return price;
  }
}
