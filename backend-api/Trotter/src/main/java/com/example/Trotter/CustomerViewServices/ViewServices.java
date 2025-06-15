package com.example.Trotter.CustomerViewServices;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.Trotter.CustomerProfile.Customer;

@Entity
@Table(name ="view_services")
public class ViewServices {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String serviceDescription;
    private double price;

    @ManyToOne
    @JoinColumn (name = "customer_id", nullable = false)
    private Customer customer;

    public ViewServices() {

    }

    public ViewServices(String serviceName, String serviceDescription, double price, Customer customer) {
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

    //public Object getAllServices() {
    //    return servicesRepository.getAllServices();
   // }

    /**
     * Method to get a service by Id
     * 
     * @param serviceId The ID of the service to retrieve
     * @return The servive with the specified ID
     */

   //  public ViewServices getServiceById(Long serviceId) {
    //    return servicesRepository.getServiceById(serviceId);
   //  }

     /**
      * Method to get services by name
      *
      * @param name The name of the service to search for
      * @return List of services with the unique name
      */
    //  public Object getServicesByName(String name) {
   //     return servicesRepository.getServiceById(id);
   //   }

   //   public List<ViewServices> getServicesByProviderId(Long providerId) {
   //     return servicesRepository.getServicesByProviderId(providerId);
  //    }
}       
