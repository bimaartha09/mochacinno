package com.ticket.concertticketmanagement.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponse {
  private Long id;
  private Long userId;
  private Long concertId;
  private String state;
  private int total;
  private long totalPrice;
  private List<TransactionItemResponse> items;
  private String createdAt;
  private String updatedAt;
}
