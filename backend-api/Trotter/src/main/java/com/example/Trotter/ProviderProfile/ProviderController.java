package com.example.Trotter.ProviderProfile;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    //@Autowired
    private final ProviderService providerService;//*edit-ser 

    //@Autowired
    public ProviderController(ProviderService providerService) {  //*edit-ser 
        this.providerService = providerService;
    }

     /**
   * Endpoint to get all providers
   *
   * @return List of all providers
   */

   @GetMapping("/providers")
   public Object getAllProviders(){
    return providerService.getAllProviders();
   }

    /**
   * Endpoint to get a provider by ID
   *
   * @param id The ID of the provider to retrieve
   * @return The provider with the specified ID
   */
   @GetMapping("/providers/{id}")
   public Provider getProviderById(@PathVariable Long id){
    return providerService.getProviderById(id);
   }

     /**
   * Endpoint to get teachers by name
   *
   * @param key The name of the teacher to search for
   * @return List of teachers with the specified name
   */
   @GetMapping("/providers/name")
   public Object getProvidersByName(@RequestParam String key){
     if (key != null) {
      return providerService.getProvidersByName(key);
    } else {
      return providerService.getAllProviders();
    }
  }

 /**
   * Endpoint to get providers by city
   *
   * @param city The city to search for
   * @return List of providers with the specified city
   */
  @GetMapping("/providers/city/{city}")
  public Object getProvidersByCity(@PathVariable String city){
    return providerService.getProvidersByCity(city);
  }

 /**
   * Endpoint to add a new provider
   *
   * @param provider The provider to add
   * @return List of all providers
   */
  @PostMapping("/providers")
  public Object addProvider(@RequestBody Provider provider){
    return providerService.addProvider(provider);
  }

 /**
   * Endpoint to update a provider
   *
   * @param provider The provider to update
   * @return List of all providers
   */
  @PutMapping("/providers/{id}")
  public Object updateProvider(@PathVariable Long id, @RequestBody Provider provider){
      provider.setProviderId(id);
    return providerService.updateProvider(provider);
  }

   /**
   * Endpoint to delete a provider by ID
   *
   * @param id The ID of the provider to delete
   * @return List of all providers
   */
  @DeleteMapping("/providers/{id}")
  public Object deleteProvider(@PathVariable Long id){
    return providerService.deleteProvider(id);
  }

  /**
   * Endpoint to get statistics by provider ID
   *
   * @param providerId The ID of the provider to retrieve statistics for
   * @return Statistics for the specified provider
   */

  
@GetMapping("/providers/{providerId}/stats")
public Object getProviderStats(@PathVariable Long providerId) {
    return providerService.getStatsByProviderId(providerId);
}

   }









