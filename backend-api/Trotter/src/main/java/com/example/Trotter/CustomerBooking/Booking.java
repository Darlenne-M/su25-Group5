package com.example.Trotter.CustomerBooking;

import java.util.ServiceLoader.Provider;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long bookingID;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String serviceId;

    private String description;

    @SuppressWarnings("rawtypes")
    @ManyToOne()
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("bookings")
    private  Provider provider;

    public void Course() {
    
    }







    
}
