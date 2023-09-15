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

import com.ticket.concertticketmanagement.request.ConcertRequest;
import com.ticket.concertticketmanagement.response.ConcertResponse;
import com.ticket.concertticketmanagement.service.ConcertService;

@RestController
@RequestMapping("/api")
public class ConcertController {

  @Autowired
  ConcertService concertService;

  @GetMapping("/concerts")
  public List<ConcertResponse> getAllConcerts() {
    return concertService.getAllConcert();
  }

  @GetMapping("/concerts/{id}")
  public ConcertResponse getConcertByID(@PathVariable(value = "id") Long concertID) {
    return concertService.getConcertByID(concertID);
  }

  @PostMapping("/concerts")
  public ConcertResponse createConcert(@Validated @RequestBody ConcertRequest request){
    return concertService.createConcert(request);
  }

}
