package com.example.Trotter.CustomerViewServices;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.Trotter.CustomerProfile.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="view_services")
public class ViewServices {
    
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn (name = "customer_id", nullable = false)
    @JsonIgnoreProperties("booking requests") //Handles reocurrsion
    private Customer customer;

  
    private String serviceName;
    private String serviceDescription;
    private double price;
   


    public ViewServices() {

    }

    public ViewServices(String serviceName,String serviceDescription, double price,String serviceLocation, Customer customer) {
      this.serviceName = serviceName;
      this.serviceDescription = serviceDescription;
      this.price = price;
      
      this.customer = customer;
    }

    /**
     * Method to get id of specific service
     * 
     * @return 
     */
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }

    public String getServiceName() {
      return serviceName;
    }

    public void setServiceName (String serviceName) {
      this.serviceName = serviceName;
    }

    public String getServiceDescription () {
      return serviceDescription;
    }

    public void setServiceDescription (String serviceDescription) {
      this.serviceDescription = serviceDescription;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }

    public Customer getCustomer() {
      return customer;
    }

    public void setCustomer( Customer customer) {
      this.customer = customer;
    }
    
}       
