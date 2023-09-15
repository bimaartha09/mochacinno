package com.ticket.concertticketmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticket.concertticketmanagement.model.constant.TransactionState;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Transaction implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private long concertId;

  @Column(nullable = false)
  private long userId;

  @Enumerated(EnumType.ORDINAL)
  private TransactionState state;

  @Column(nullable = false)
  private int total;

  @Column(nullable = false)
  private long totalPrice;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;
}
