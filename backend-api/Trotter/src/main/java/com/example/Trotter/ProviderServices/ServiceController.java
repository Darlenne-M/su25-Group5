package com.example.Trotter.ProviderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Generated;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
     * Endpoint to get all services
     *
     * @return List of all services
     */

    @GetMapping("/home")
    public Object getAllServices(Model model) {
        model.addAttribute("provider-homepage", serviceService.getAllServices());
        model.addAttribute("title", "Your Services");
        return "provider-homepage";
    }

    /**
     * Endpoint to get a service by ID
     *
     * @param serviceId The ID of the service to retrieve
     * @return The service with the specified ID
     */
    @GetMapping("/home/services/{serviceId}")
    public Object getServiceById(@PathVariable long id, Model model) {
        //return serviceService.getServiceById(serviceId);
        model.addAttribute("service", serviceService.getServiceById(id));
        model.addAttribute("title", "Service no. " + id);
        return "provider-service-details";
    }

    /**
     * Endpoint to get services by name
     *
     * @param name The name of the service to search for
     * @return List of services with the specified name
     */
    @Generated("/home/services/name")
    public Object getServicesByName(@RequestParam String key, Model model) {
        if (key != null) {
            model.addAttribute("provider-homepage", serviceService.getServicesByName(key));
            model.addAttribute("title", "Services By Name" + key);
            return "provider-homepage";
        } else {
            return "redirect:/home/";
        }
    }
    @GetMapping("/home/services/createForm")
    public Object showCreateForm(Model model){
        ServiceEntity service = new ServiceEntity();
        model.addAttribute("service", service);
        model.addAttribute("title", "Create New Service");
        return "service-create";
    }

      /**
   * Endpoint to add a new service
   *
   * @param service The service to add
   * @return List of all services
   */
    @PostMapping("/home/services")
    public Object addService(ServiceEntity service, @RequestParam MultipartFile picture){
        //return serviceService.addService(service);
        ServiceEntity newService = serviceService.addService(service, picture);
        return "redirect:/home/services/" + newService.getServiceId();
    }
      /**
   * Endpoint to update a service
   *
   * @param serviceId The ID of the service to update
   * @param service   The updated service information
   * @return The updated service
 
    @PutMapping("/services/{serviceId}")
    public ServiceEntity updateService(@PathVariable Long serviceId, @RequestBody ServiceEntity service){
        service.setServiceId(serviceId);
        serviceService.updateService(service);
        return serviceService.getServiceById(serviceId);
    }  */

    @GetMapping("/home/services/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model){
        ServiceEntity service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        model.addAttribute("title", "Update Service no." + id);
        return "provider-service-update";
    }

    @PostMapping("/home/services/update/{id}")
    public Object updateService(@PathVariable Long id, ServiceEntity service, @RequestParam MultipartFile picture){
        serviceService.updateService(id, service, picture);
        return "redirect:/home/" + id;
    }

/**
   * Endpoint to delete a service by ID
   *
   * @param serviceId The ID of the service to delete
   */
    @DeleteMapping("/home/services/{serviceId}")
    public Object deleteServiceById(@PathVariable Long id){
        serviceService.deleteServiceById(id);
        return "redirect:/home/";
    }

      /**
   * Endpoint to get services by provider ID
   *
   * @param providerId The ID of the provider to search for
   * @return List of services provider by the specified provider
   */

   @PostMapping("/home/services/writeFile")
  public Object writeJson(@RequestBody ServiceEntity service) {
    serviceService.writeJson(service);
    return serviceService.writeJson(service);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/home/services/readFile")
  public Object readJson() {
    return serviceService.readJson();

  }

    @GetMapping("/services/provider/{providerId}")
    public Object getServicesByProviderId(@PathVariable Long providerId){
        return serviceService.getServicesByProviderId(providerId);
    }



}
