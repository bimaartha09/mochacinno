package com.ticket.concertticketmanagement.repository;

import com.ticket.concertticketmanagement.model.ConcertCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertCategoryRepository extends JpaRepository<ConcertCategory, Long> {

}
