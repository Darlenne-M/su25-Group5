package com.example.Trotter.ProviderServices;

import com.example.Trotter.ProviderProfile.Provider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "services")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //-ser Fixes no serializer found for class error
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String serviceName;

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

    @ManyToOne(fetch = FetchType.LAZY)  //ser
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("services") // Keep this for bidirectional control
    private Provider provider;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //Fixes no serializer found for class error
    
    public ServiceEntity(){

    }

    public ServiceEntity(Long serviceId, String serviceName, String description, String experience, float pricing, String preferredContactMethod, String serviceLocations, String travelRadius, String imagePath){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = preferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
    }
     public ServiceEntity(String serviceName, String description, String experience, float pricing, String preferredContactMethod, String serviceLocations, String travelRadius, String imagePath){
        this.serviceName = serviceName;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = preferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
    }

     public ServiceEntity(Long serviceId, String serviceName, String description, String experience, float pricing, String preferredContactMethod, String serviceLocations, String travelRadius, String imagePath, Provider provider){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = preferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
        this.provider = provider;
    }

    
     public ServiceEntity(String serviceName, String description, String experience, float pricing, String preferredContactMethod, String serviceLocations, String travelRadius, String imagePath, Provider provider){
        this.serviceName = serviceName;
        this.description = description;
        this.experience = experience;
        this.pricing = pricing;
        this.preferredContactMethod = preferredContactMethod;
        this.serviceLocations = serviceLocations;
        this.travelRadius = travelRadius;
        this.imagePath = imagePath;
        this.provider = provider;
    }

    public Long getServiceId(){
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

    public String getServiceName(){
        return serviceName;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
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
      public void setPreferredContactMethod(String preferredContactMethod){
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
