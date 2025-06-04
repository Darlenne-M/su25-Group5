package com.example.Trotter.ProviderServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

     /**
   * Method to get all services
   *
   * @return List of all services
   */

   public Object getAllServices(){
    return serviceRepository.findAll();
   }

    /**
   * Method to get a service by ID
   *
   * @param serviceId The ID of the service to retrieve
   * @return The service with the specified ID
   */

   public ServiceEntity getServiceById(Long serviceId){
    return serviceRepository.findById(serviceId).orElse(null); 
  }

     /**
   * Method to get services by name
   *
   * @param name The name of the service to search for
   * @return List of services with the specified name
   */
   public Object getServicesByName(String name){
    return serviceRepository.getServicesByServiceName(name);
   }

    /**
   * Method to add a new service
   *
   * @param service The service to add
   * @return List of all services
   */
   public Object addService(ServiceEntity service){
    return serviceRepository.save(service);
   }

    /**
   * Method to update a service
   *
   * @param service The service to update
   * @return List of all services
   */
   public Object updateService(ServiceEntity service){
    return serviceRepository.save(service);
   }

     /**
   * Method to delete a service by ID
   *
   * @param serviceId The ID of the service to delete
   * @return List of all services after deletion
   */
   public Object deleteServiceById(Long serviceId){
    serviceRepository.deleteById(serviceId);
    return serviceRepository.findAll();
   }

   public List<ServiceEntity> getServicesByProviderId(Long providerId){
    return serviceRepository.getServicesByProviderId(providerId);
   }

}
