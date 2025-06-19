package com.example.Trotter.ProviderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
     * Endpoint to get all services
     *
     * @return List of all services
     */

    @GetMapping("/services")
    public Object getAllServices() {
        return serviceService.getAllServices();
    }

    /**
     * Endpoint to get a service by ID
     *
     * @param serviceId The ID of the service to retrieve
     * @return The service with the specified ID
     */
    @GetMapping("/services/{serviceId}")
    public ServiceEntity getServiceById(@PathVariable Long serviceId) {
        return serviceService.getServiceById(serviceId);
    }

    /**
     * Endpoint to get services by name
     *
     * @param name The name of the service to search for
     * @return List of services with the specified name
     */
    @GetMapping("/services/name")
    public Object getServicesByName(@RequestParam String key) {
        if (key != null) {
            return serviceService.getServicesByName(key);
            } else {
            return serviceService.getAllServices();
        }
    }

    /**
   * Endpoint to add a new service
   *
   * @param service The service to add
   * @return List of all services
   */
    @PostMapping("/services")
    public Object addService(@RequestBody ServiceEntity service){
        return serviceService.addService(service);
    }
      /**
   * Endpoint to update a service
   *
   * @param serviceId The ID of the service to update
   * @param service   The updated service information
   * @return The updated service
   */
    @PutMapping("/services/{serviceId}")
    public ServiceEntity updateService(@PathVariable Long serviceId, @RequestBody ServiceEntity service){
        service.setServiceId(serviceId);
        serviceService.updateService(service);
        return serviceService.getServiceById(serviceId);
    }

/**
   * Endpoint to delete a service by ID
   *
   * @param serviceId The ID of the service to delete
   */
    @DeleteMapping("/services/{serviceId}")
    public void deleteService(@PathVariable Long serviceId){
        serviceService.deleteServiceById(serviceId);
    }

      /**
   * Endpoint to get services by provider ID
   *
   * @param providerId The ID of the provider to search for
   * @return List of services provider by the specified provider
   */
    @GetMapping("/services/provider/{providerId}")
    public Object getServicesByProviderId(@PathVariable Long providerId){
        return serviceService.getServicesByProviderId(providerId);
    }



}
