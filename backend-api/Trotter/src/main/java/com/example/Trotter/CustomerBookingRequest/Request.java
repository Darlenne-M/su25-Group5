package com.example.Trotter.CustomerBookingRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.example.Trotter.CustomerProfile.Customer;
import com.example.Trotter.CustomerViewServices.ViewServices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking requests")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    //@ManyToOne()
    //@JoinColumn(name = "bookingId", nullable = false)
    //@JsonIgnoreProperties("bookings")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "service_id",  nullable = false)
    @JsonIgnoreProperties("customer") //Foreign key column
    private ViewServices service;
    @Column(name = "bookingDate")

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable = false)

    private String status; //Approved, Canceled

    private String notes;

    private LocalDateTime createdAt;

    private Long bookingId;

    public Request() {

    }

    public Request(Long bookingId, Customer customer, ViewServices service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt) {
        this.bookingId = bookingId;
        this.service = service;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Request(Customer customer, ViewServices service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt ) {
        this.customer = customer;
        this.service = service;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ViewServices getService() {
        return service;
    }

    public void setService(ViewServices service) {
        this.service = service;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookinDate) {
        this.bookingDate = bookinDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime starTime) {
        this.startTime = starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

 //


 //
    
}
