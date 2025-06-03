package com.example.Trotter.ProviderServices;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String title;
    private String type;
    private String description;
    private String experience;
    private String pricing;
    private String preferredContactMethod;
    private String serviceLocations;
    private String travelRadius;
    private String imagePath;
    
}
