package com.ticket.concertticketmanagement.serializer;

import com.ticket.concertticketmanagement.model.User;
import com.ticket.concertticketmanagement.response.UserResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSerializer {

  private User user;

  public UserResponse constructResponse() {
    UserResponse response = new UserResponse();

    response.setFullName(user.getName());
    response.setPhoneNumber(user.getPhoneNumber());
    response.setEmail(user.getEmail());
    response.setActive(user.isActive());
    response.setCreatedAt(user.getCreatedAt().toString());
    response.setUpdatedAt(user.getUpdatedAt().toString());

    return response;
  }

}
