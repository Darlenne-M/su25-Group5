package com.example.Trotter.ProviderBookings;

import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.CustomerProfile.Customer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "bookings")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)  //Always use LAZY for ManyToOne unless truly needed EAGERLY-ser
    @JoinColumn(name = "customer_id", nullable = false)
    // @JsonIgnoreProperties("bookings")//-*ser 
     @JsonIgnore    //This will completely hide the 'customer' object when serializing a Booking
     private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)  //Always use LAZY for ManyToOne unless truly needed EAGERLY-ser
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties("provider")
    private ServiceEntity service;

    //Transient field to accept customerId from JSON
    @Transient // This tells JPA to ignore this field in the database mapping-ser
    private Long customerId;

    @Transient
    private Long serviceId;     // Adding for serviceId too, for consistency of JSON deserilization -ser

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable = false)
    private String status; // Example values: PENDING, CONFIRMED, COMPLETED, CANCELED 

    private String notes;

    private LocalDateTime createdAt;

    public Booking() {

    }

    public Booking(Long bookingId, Customer customer, ServiceEntity service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt){
        this.bookingId = bookingId;
        this.customer = customer;
        this.service = service;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
    }
      public Booking(Customer customer, ServiceEntity service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt){
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

    public void setBookingId(Long bookingId){
        this.bookingId = bookingId;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public ServiceEntity getService(){
        return service;
    }

    public void setService(ServiceEntity service){
        this.service = service;
    }
    
    public LocalDate getBookingDate(){
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate){
        this.bookingDate = bookingDate;
    }
        
    public LocalTime getStartTime(){
        return startTime;
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }
  
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    

    public String getNotes(){
        return notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }
    
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public Long getCustomerId() {
       return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceId() {
       return serviceId;
    }

    public void setServiceId(Long serviceId) {  
        this.serviceId = serviceId;
    }
       

    
}
