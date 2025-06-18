package com.example.Trotter.CustomerViewServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trotter.ProviderServices.ServiceService;

import jakarta.annotation.Generated;

@RestController
@RequestMapping("/customer/services")  //***Unique base path for customer views
public class ViewServicesController {
    private final ServiceService serviceService;

    //@Autowired
    public ViewServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

   // @Autowired
   // private ServiceRepository serviceRepository;

    /**
     * Endpoint to get all services
     * 
     * @return List of all services
     */
    @GetMapping("/customer/services")
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
    public Object getServiceById(@PathVariable Long serviceId) {
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

}