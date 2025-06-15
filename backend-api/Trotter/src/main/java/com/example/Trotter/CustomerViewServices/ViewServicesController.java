package com.example.Trotter.CustomerViewServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trotter.ProviderServices.ServiceService;

import jakarta.annotation.Generated;

@RestController
public class ViewServicesController {
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
     * Endpoint to get service by ID
     * 
     * @param serviceId The ID of the service to retrieve
     * @return The service with the specified ID
     */
    @GetMapping("/services/{serviceId}")
    public com.example.Trotter.ProviderServices.ServiceEntity getServiceById(@PathVariable Long serviceId) {
        return serviceService.getServiceById(serviceId);
    }

    /**
     * Endpoint to get services by name
     * 
     * @param name The name of the service to search for
     * @return List of services with specified name
     */
    @Generated("/services/name")
    public Object getServicesByName(@RequestParam String key) {
        if (key != null) {
            return serviceService.getServicesByName(key);
        }else {
            return serviceService.getAllServices();
        }
    }

    /**
     * Endpoint to view services
     * 
     * return List of all services
     */
    @SuppressWarnings("null")
    @PostMapping("/services")
     public Object getAllCustomers() {
        ViewServicesController customerService = null;
        return customerService.getAllCustomers();
    }

    /**
     * Endpoint to  get service by provider ID
     * 
     * @param providerId The ID of the provider to search
     * @return List of services provided by the provider
     */
    @GetMapping("/services/provider/{providerId}")
    public Object getServicesByProviderId(@PathVariable Long providerId) {
        return serviceService.getServicesByProviderId(providerId);
    }

}