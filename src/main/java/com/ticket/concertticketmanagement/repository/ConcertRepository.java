package com.ticket.concertticketmanagement.repository;

import com.ticket.concertticketmanagement.model.Concert;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

  List<Concert> findByName(String name);

  List<Concert> findByStartTimeBetween(Date start, Date end);

  List<Concert> findByStartTimeGreaterThanEqual(Date start_time);
}
