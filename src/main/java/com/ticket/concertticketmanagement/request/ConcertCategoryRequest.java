package com.ticket.concertticketmanagement.request;

public class ConcertCategoryRequest {
  private String categoryName;
  private Long capacity;
  private int price;

  public Long getCapacity() {
    return capacity;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public int getPrice() {
    return price;
  }
}
