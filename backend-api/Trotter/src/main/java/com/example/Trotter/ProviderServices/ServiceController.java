package com.example.Trotter.ProviderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.Trotter.ProviderProfile.Provider;
import com.example.Trotter.ProviderProfile.ProviderRepository;

import jakarta.annotation.Generated;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ProviderRepository providerRepository;

    /**
     * Endpoint to get all services
     *
     * @return List of all services
     */
    

    @GetMapping("/provider-homepage/{providerId}/services")
    public Object getAllServices(@PathVariable Long providerId, Model model) {
        model.addAttribute("servicesList", serviceService.getServicesByProviderId(providerId));
        model.addAttribute("providerId", providerId);
        return "provider-homepage";
    }

    /**
     * Endpoint to get a service by ID
     *
     * @param serviceId The ID of the service to retrieve
     * @return The service with the specified ID
     * 
     *         @GetMapping("/provider-homepage/{providerId}/services/{serviceId}")
     *         public Object getServiceById(@PathVariable long id, Model model) {
     *         // return serviceService.getServiceById(serviceId);
     *         model.addAttribute("service", serviceService.getServiceById(id));
     *         model.addAttribute("title", "Service no. " + id);
     *         return "provider-service-details";
     *         }
     */
    @GetMapping("/provider-homepage/{providerId}/services/{serviceId}")
    public Object getServiceById(@PathVariable Long providerId, @PathVariable Long serviceId, Model model) {
        model.addAttribute("service", serviceService.getServiceById(serviceId));
        model.addAttribute("provider", serviceService.getServicesByProviderId(providerId));
        return "provider-service-details";
    }

    /**
     * Endpoint to get services by name
     *
     * @param name The name of the service to search for
     * @return List of services with the specified name
     */
    @GetMapping("/provider-homepage/{providerId}/services/name")
    public Object getServicesByName(@RequestParam String key, Model model) {
        if (key != null) {
            model.addAttribute("servicesList", serviceService.getServicesByName(key));
            model.addAttribute("title", "Services By Name" + key);
            return "provider-homepage";
        } else {
            return "redirect:/services/";
        }
    }

    @GetMapping("/provider-homepage/{providerId}/services/createForm")
    public Object showCreateForm(@PathVariable Long providerId, Model model) {
        ServiceEntity service = new ServiceEntity();
        model.addAttribute("service", service);
        model.addAttribute("providerId", providerId); // ✅ Make sure this is passed to FreeMarker
        return "provider-create-service";
    }

    /**
     * Endpoint to add a new service
     *
     * @param service The service to add
     * @return List of all services
     */
    @PostMapping("/provider-homepage/{providerId}/services")
    public Object addService(@PathVariable Long providerId, ServiceEntity service,
            @RequestParam MultipartFile picture) {
        // return serviceService.addService(service);
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        service.setProvider(provider);
        ServiceEntity newService = serviceService.addService(service, picture);
        return "redirect:/provider-homepage/" + providerId;
        // return "redirect:/provider-homepage/" + providerId + "/services/" +
        // newService.getServiceId();
    }

    /**
     * Endpoint to update a service
     *
     * @param serviceId The ID of the service to update
     * @param service   The updated service information
     * @return The updated service
     * 
     *         @PutMapping("/services/{serviceId}")
     *         public ServiceEntity updateService(@PathVariable Long
     *         serviceId, @RequestBody ServiceEntity service){
     *         service.setServiceId(serviceId);
     *         serviceService.updateService(service);
     *         return serviceService.getServiceById(serviceId);
     *         }
     */

    @GetMapping("/provider-homepage/{providerId}/services/updateForm")
    public Object showUpdateForm(@PathVariable Long providerId, Model model) {
        ServiceEntity service = serviceService.getServiceById(providerId);
        model.addAttribute("service", service);
        return "provider-service-details";
    }

    @PostMapping("/provider-homepage/{providerId}/services/update")
    public Object updateService(@PathVariable Long providerId, ServiceEntity service,
            @RequestParam MultipartFile picture) {
        serviceService.updateService(providerId, service, picture);
        return "redirect:/provider-homepage/" + providerId;
    }

    /**
     * Endpoint to delete a service by ID
     *
     * @param serviceId The ID of the service to delete
     */
    @GetMapping("/provider-homepage/{providerId}/delete/{serviceId}")
    public Object deleteServiceById(@PathVariable Long providerId, @PathVariable Long serviceId) {
        serviceService.deleteServiceById(serviceId);
        return "redirect:/provider-homepage/" + providerId;
    }

    /**
     * Endpoint to get services by provider ID
     *
     * @param providerId The ID of the provider to search for
     * @return List of services provider by the specified provider
     */

    @PostMapping("/services/writeFile")
    public Object writeJson(@RequestBody ServiceEntity service) {
        serviceService.writeJson(service);
        return serviceService.writeJson(service);
    }

    /**
     * Endpoint to read a JSON file and return its contents
     *
     * @return The contents of the JSON file
     */
    @GetMapping("/services/readFile")
    public Object readJson() {
        return serviceService.readJson();

    }

    @GetMapping("/services/provider/{providerId}")
    public Object getServicesByProviderId(@PathVariable Long providerId) {
        return serviceService.getServicesByProviderId(providerId);
    }

}
