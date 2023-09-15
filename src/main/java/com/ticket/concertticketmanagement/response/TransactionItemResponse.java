package com.ticket.concertticketmanagement.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionItemResponse {
  private Long id;
  private Long transactionId;
  private Long category;
  private int total;
  private int price;
  private String createdAt;
  private String updatedAt;
}
