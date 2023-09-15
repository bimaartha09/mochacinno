package com.ticket.concertticketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.concertticketmanagement.request.UserRequest;
import com.ticket.concertticketmanagement.response.UserResponse;
import com.ticket.concertticketmanagement.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/users")
  public List<UserResponse> getAllUsers() {
    return userService.getAllUser();
  }

  @GetMapping("/users/{id}")
  public UserResponse getUserByID(@PathVariable(value = "id") Long userID) {
    return userService.getUserByID(userID);
  }

  @PostMapping("/users")
  public UserResponse createUser(@Validated @RequestBody UserRequest request){
    return userService.createUser(request);
  }
}
