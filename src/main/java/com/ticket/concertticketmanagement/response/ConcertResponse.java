package com.ticket.concertticketmanagement.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConcertResponse {
  private String name;
  private String description;
  private String responsibleName;
  private long capacity;
  private long availableCapacity;
  private String startTime;
  private String createdAt;
  private String updatedAt;
}
