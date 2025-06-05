package com.example.Trotter.CustomerViewServices;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ViewServices {
    
    @Autowired
    private ServiceRepository serviceRepository;

    /**
     * Mehtod get all services
     * 
     * @return List of all services
     */
    public Object getAllServices() {
        return serviceRepository.findAll();
    }

    /**
     * Meht to get a service by Id
     * 
     * @param serviceId The ID of the service to retrieve
     * @return The servive with the specified ID
     */

     public ServiceEntity getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElse(null);
     }

     /**
      * Method to get services by name
      *
      * @param name The name of the service to search for
      * @return List of services with the unique name
      */
      public Object getServicesByName(String name) {
        return serviceRepository.getServiceByServiceName(name);
      }

      public List<ServiceEntity> getServicesByProviderId(Long providerId) {
        return serviceRepository.getServicesByProviderId(providerId);
      }
}       
