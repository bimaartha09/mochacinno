package com.ticket.concertticketmanagement.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
  private long id;
  private String fullName;
  private String phoneNumber;
  private String email;
  private boolean active;
  private String createdAt;
  private String updatedAt;
}
