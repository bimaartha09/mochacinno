package com.ticket.concertticketmanagement.repository;

import com.ticket.concertticketmanagement.model.User;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByPhoneNumber(String phoneNumber);

  List<User> findByEmail(String email);

  List<User> findByActive(int active);
}
