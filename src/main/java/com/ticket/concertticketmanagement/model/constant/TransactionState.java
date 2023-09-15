package com.ticket.concertticketmanagement.model.constant;

public enum TransactionState {
  PENDING("pending"), SUCCESSED("successed"), RECEIVED("received"), CANCELLED("cancelled"), REFUNDED("refunded");

  private String state;

  private TransactionState(String state) {
      this.state = state;
  }

  public String getCode() {
      return state;
  }
}
