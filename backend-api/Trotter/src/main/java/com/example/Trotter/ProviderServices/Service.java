package com.example.Trotter.ProviderServices;

import com.example.Trotter.ProviderProfile.Provider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String title;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    private String experience;

    @Column(nullable = false)
    private float pricing;
    @Column(nullable = false)
    private String preferredContactMethod;

    @Column(nullable = false)
    private String serviceLocations;

    private String travelRadius;
    private String imagePath;

    @ManyToOne()
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("services")
    private Provider provider;
    
    public Service(){

    }

    public Service(Long serviceId, String title, String type, String description, String experience, float pricing, String perferredContactMethod, String serviceLocations, String travelRadius, String imagePath){
        this.serviceId = serviceId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = perferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
    }
     public Service(String title, String type, String description, String experience, float pricing, String perferredContactMethod, String serviceLocations, String travelRadius, String imagePath){
        this.title = title;
        this.type = type;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = perferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
    }

     public Service(Long serviceId, String title, String type, String description, String experience, float pricing, String perferredContactMethod, String serviceLocations, String travelRadius, String imagePath, Provider provider){
        this.serviceId = serviceId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = perferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
        this.provider = provider;
    }

    
     public Service(String title, String type, String description, String experience, float pricing, String perferredContactMethod, String serviceLocations, String travelRadius, String imagePath, Provider provider){
        this.title = title;
        this.type = type;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = perferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
        this.provider = provider;
    }

    public Long getProviderId(){
        return serviceId;
    }

    public void setServiceId(Long serviceId){
        this.serviceId = serviceId;
    }
     
    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
      public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
       
    public String getExperience(){
        return experience;
    }

    public void setExperience(String experience){
        this.experience = experience;
    }

    public float getPricing(){
        return pricing;
    }
    
    public void setPricing(float pricing){
        this.pricing = pricing;
    }
    
    public String getPreferredContactMethod(){
        return preferredContactMethod;
    }
      public void getPreferredContactMethod(String preferredContactMethod){
        this.preferredContactMethod = preferredContactMethod;
    }
    
    public String getServiceLocations(){
        return serviceLocations;
    }

    public void setServiceLocations(String serviceLocations){
        this.serviceLocations = serviceLocations;
    }
    
    public String getTravelRadius(){
        return travelRadius;
    }

    public void setTravelRadius(String travelRadius){
        this.travelRadius = travelRadius;
    }
    
    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
       
       

}
