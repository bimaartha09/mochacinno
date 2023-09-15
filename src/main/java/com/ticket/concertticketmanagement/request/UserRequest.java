package com.ticket.concertticketmanagement.request;

public class UserRequest {
  private String userFullName;
  private String password;
  private String phone;
  private String email;

  public String getUserFullName() {
    return userFullName;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
}
