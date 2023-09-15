package com.ticket.concertticketmanagement.repository;

import com.ticket.concertticketmanagement.model.TransactionItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {
  List<TransactionItem> findByTransactionId();
}
