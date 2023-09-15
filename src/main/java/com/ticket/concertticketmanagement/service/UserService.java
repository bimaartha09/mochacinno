package com.ticket.concertticketmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.concertticketmanagement.exception.DuplicateUserException;
import com.ticket.concertticketmanagement.exception.NotFoundException;
import com.ticket.concertticketmanagement.model.User;
import com.ticket.concertticketmanagement.repository.UserRepository;
import com.ticket.concertticketmanagement.request.UserRequest;
import com.ticket.concertticketmanagement.response.UserResponse;
import com.ticket.concertticketmanagement.serializer.UserSerializer;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public UserResponse createUser(UserRequest request) {
    List<User> existingUser = getUserByPhoneNumber(request.getPhone());

    if (existingUser.size() > 0) {
      throw new DuplicateUserException("phone number", request.getPhone());
    }

    existingUser = getUserByEmail(request.getEmail());

    if (existingUser.size() > 0) {
      throw new DuplicateUserException("email", request.getEmail());
    }

    User user = new User();

    user.setName(request.getUserFullName());
    user.setPassword(request.getPassword());
    user.setEmail(request.getEmail());
    user.setPhoneNumber(request.getPhone());
    user.setActive(true);

    UserSerializer serializer = new UserSerializer();
    serializer.setUser(user);

    return serializer.constructResponse();
  }

  public List<UserResponse> getAllUser(){
    List<User> users = userRepository.findAll();
    List<UserResponse> resList = new ArrayList<>();

    for (User u: users) {
      UserSerializer serializer = new UserSerializer();
      serializer.setUser(u);

      resList.add(serializer.constructResponse());
    }

    return resList;
  }

  public UserResponse getUserByID(long userID) {
    User user = userRepository.findById(userID)
      .orElseThrow(() -> new NotFoundException("concertID", userID));

    UserSerializer serializer = new UserSerializer();
    serializer.setUser(user);

    return serializer.constructResponse();
  }

  private List<User> getUserByPhoneNumber(String phoneNumber) {
    return userRepository.findByPhoneNumber(phoneNumber);
  }

  private List<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
