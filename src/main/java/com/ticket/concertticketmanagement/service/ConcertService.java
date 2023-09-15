package com.ticket.concertticketmanagement.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.concertticketmanagement.exception.InvalidRequestException;
import com.ticket.concertticketmanagement.exception.NotFoundException;
import com.ticket.concertticketmanagement.model.Concert;
import com.ticket.concertticketmanagement.model.ConcertCategory;
import com.ticket.concertticketmanagement.repository.ConcertCategoryRepository;
import com.ticket.concertticketmanagement.repository.ConcertRepository;
import com.ticket.concertticketmanagement.request.ConcertCategoryRequest;
import com.ticket.concertticketmanagement.request.ConcertRequest;
import com.ticket.concertticketmanagement.response.ConcertResponse;
import com.ticket.concertticketmanagement.serializer.ConcertSerializer;

@Service
public class ConcertService {

  @Autowired
  ConcertRepository concertRepository;

  @Autowired
  ConcertCategoryRepository concertCategoryRepository;

  public ConcertResponse createConcert(ConcertRequest request) throws Exception {
    System.out.println("request : " + request.getStartTime());

    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime dateTime = LocalDateTime.parse(request.getStartTime());

    if (timeNow.isAfter(dateTime)) {
      throw new InvalidRequestException("start_time");
    }

    // add concert to database
    Concert concert = new Concert();

    concert.setName(request.getConcertName());
    concert.setDescription(request.getNotes());
    concert.setStartTime(Date.from(timeNow.atZone(ZoneId.systemDefault()).toInstant()));
    concert.setCapacity(request.getCapacity());
    concert.setAvailableCapacity(request.getCapacity());
    concert.setResponsibleName(request.getResponsibleName());

    concert = concertRepository.save(concert);

    // add concert category to database
    List<ConcertCategory> ccList = new ArrayList<>();

    for (ConcertCategoryRequest cc: request.getCategories()) {
      ConcertCategory category = new ConcertCategory();

      category.setCategoryName(cc.getCategoryName());
      category.setConcertId(concert.getId());
      category.setCapacity(cc.getCapacity());
      category.setAvailableCapacity(cc.getCapacity());
      category.setPrice(cc.getPrice());

      System.out.println("category = " + category.toString());

      ccList.add(category);
    }

    concertCategoryRepository.saveAll(ccList);

    ConcertSerializer serializer = new ConcertSerializer();
    serializer.setConcert(concert);

    return serializer.constructResponse();
  }

  public List<ConcertResponse> getAllConcert(){
    List<Concert> cList = concertRepository.findAll();
    List<ConcertResponse> resList = new ArrayList<>();

    for (Concert c: cList) {
      ConcertSerializer ser = new ConcertSerializer();
      ser.setConcert(c);

      resList.add(ser.constructResponse());
    }

    return resList;
  }

  public ConcertResponse getConcertByID(long concertID) {
    Concert concert = concertRepository.findById(concertID)
      .orElseThrow(() -> new NotFoundException("concertID", concertID));

    ConcertSerializer ser = new ConcertSerializer();
    ser.setConcert(concert);

    return ser.constructResponse();
  }
}
