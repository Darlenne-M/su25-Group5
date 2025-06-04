package com.example.Trotter.ProviderBookings;

import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderProfile.Provider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "bookings")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne()
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("bookings")
    private Provider provider;

    @ManyToOne()
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties("provider")
    private ServiceEntity service;

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable = false)
    private String status; // Example values: PENDING, CONFIRMED, COMPLETED, CANCELED

    private String notes;

    private LocalDateTime createdAt;

    public Booking(){

    }

    public Booking(Long bookingId, Provider provider, ServiceEntity service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt){
        this.bookingId = bookingId;
        this.provider = provider;
        this.service = service;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
    }
      public Booking(Provider provider, ServiceEntity service, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, String status, String notes, LocalDateTime createdAt){
        this.provider = provider;
        this.service = service;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getBookingId(){
        return bookingId;
    }
    public void setBookingId(Long bookingId){
        this.bookingId = bookingId;
    }

    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
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
       

    
}
