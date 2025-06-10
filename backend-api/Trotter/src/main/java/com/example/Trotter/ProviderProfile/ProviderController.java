package com.example.Trotter.ProviderProfile;

import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderServices.ServiceService;
import com.example.Trotter.ProviderServices.ServiceService;
import java.io.Serial;
import java.util.List;

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

@Controller
public class ProviderController {

  @Autowired
  private ProviderService providerService;

  @Autowired
  private ServiceService serviceService;

  @GetMapping("/providers/createForm")
  public Object showCreateForm(Model model) {
    Provider provider = new Provider();
    model.addAttribute("provider", provider);
    return "provider-sign-up";
  }

  /**
   * Endpoint to add a new provider
   *
   * @param provider The provider to add
   * @return List of all providers
   */
  @PostMapping("/providers")
  public Object addProvider(Provider provider, @RequestParam MultipartFile picture) {
    // return providerService.addProvider(provider);
    Provider newProvider = providerService.addProvider(provider, picture);
    return "redirect:/provider-homepage/" + newProvider.getProviderId(); // redirect to their homepage
  }
  @GetMapping("/provider-homepage/{providerId}")
public String providerHomepage(@PathVariable Long providerId, Model model) {
    Provider provider = providerService.getProviderById(providerId);
    if (provider == null) {
        return "error"; // or custom 404 page
    }
    // Fetch services by provider ID
    List<ServiceEntity> servicesList = serviceService.getServicesByProviderId(providerId);
    
    // Add provider and services to the model
    model.addAttribute("provider", provider);
    model.addAttribute("servicesList", servicesList);
    
    return "provider-homepage";
}

/* 
  @GetMapping("/provider-homepage/{providerId}")
  public String providerHomepage(@PathVariable Long providerId, Model model) {
    Provider provider = providerService.getProviderById(providerId);
    if (provider == null) {
      return "error"; // or custom 404 page
    }
    model.addAttribute("provider", provider);
    return "provider-homepage";
  }*/

  /**
   * Endpoint to update a provider
   *
   * @param provider The provider to update
   * @return List of all providers
   */
  @GetMapping("/provider-homepage/{providerId}/updateForm")
  public Object showUpdateForm(@PathVariable Long providerId, Model model) {
    Provider provider = providerService.getProviderById(providerId);
    if (provider == null) {
      return "error"; // or custom error view
    }
    model.addAttribute("provider", provider);
    return "provider-profile";
  }

  @PostMapping("/provider-homepage/{providerId}/update")
  public Object updateProvider(@PathVariable Long providerId, Provider provider, @RequestParam MultipartFile picture) {
    providerService.updateProvider(providerId, provider, picture);
    return "redirect:/provider-homepage/" + providerId;
  }

  /**
   * Endpoint to delete a provider by ID
   *
   * @param id The ID of the provider to delete
   */
  @GetMapping("/providers/delete/{providerId}")
  public Object deleteProvider(@PathVariable Long id){
    providerService.deleteProvider(id);
    return "redirect:/homepage/";
  }

  @PostMapping("/providers/writeFile")
  public Object writeJson(@RequestBody Provider provider) {
    providerService.writeJson(provider);
    return providerService.writeJson(provider);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * 
   * @return The contents of the JSON file
   */
  @GetMapping("/providers/readFile")
  public Object readJson() {
    return providerService.readJson();

  }

  @GetMapping("/providers/{providerId}/stats")
  public Object getProviderStats(@PathVariable Long providerId) {
    return providerService.getStatsByProviderId(providerId);
  }

}
