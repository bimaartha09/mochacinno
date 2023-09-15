package com.ticket.concertticketmanagement.serializer;

import com.ticket.concertticketmanagement.model.Concert;
import com.ticket.concertticketmanagement.response.ConcertResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConcertSerializer {

  private Concert concert;

  public ConcertResponse constructResponse() {
    ConcertResponse response = new ConcertResponse();

    response.setId(concert.getId());
    response.setName(concert.getName());
    response.setDescription(concert.getDescription());
    response.setResponsibleName(concert.getResponsibleName());
    response.setStartTime(concert.getStartTime().toString());
    response.setCapacity(concert.getCapacity());
    response.setAvailableCapacity(concert.getAvailableCapacity());
    response.setCreatedAt(concert.getCreatedAt().toString());
    response.setUpdatedAt(concert.getUpdatedAt().toString());

    return response;
  }
}
