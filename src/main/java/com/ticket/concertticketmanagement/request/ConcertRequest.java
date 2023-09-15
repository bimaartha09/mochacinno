package com.ticket.concertticketmanagement.request;

import java.util.List;

public class ConcertRequest {
  private String concertName;
  private String notes;
  private String startTime;
  private Long capacity;
  private String responsibleName;
  private List<ConcertCategoryRequest> categories;

  public String getNotes() {
    return notes;
  }
  public String getStartTime() {
    return startTime;
  }

  public String getConcertName() {
    return concertName;
  }

  public Long getCapacity() {
    return capacity;
  }

  public String getResponsibleName() {
    return responsibleName;
  }

  public List<ConcertCategoryRequest> getCategories() {
    return categories;
  }
}
