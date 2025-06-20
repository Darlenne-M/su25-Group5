package com.example.Trotter.ProviderProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderServices.ServiceService;
import com.example.Trotter.ProviderBookings.BookingService;


@Service
public class ProviderService {
    //@Autowired
    private final ProviderRepository providerRepository;//*edit-ser */

    //@Autowired
    public ProviderService(ProviderRepository providerRepository) {
      this.providerRepository = providerRepository;
    }

    
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private BookingService bookingService;
     /**
   * Method to get all providers
   *
   * @return List of all providers
   */
    public Object getAllProviders(){
        return providerRepository.findAll();
    }

    /**
   * Method to get a provider by ID
   *
   * @param providerId The ID of the provider to retrieve
   * @return The provider with the specified ID
   */

   public Provider getProviderById(Long providerId){
    return providerRepository.findById(providerId).orElse(null);
   }

     /**
   * Method to get providers by name
   *
   * @param name The name of the provider to search for
   * @return List of providers with the specified name
   */

   public List<Provider> getProvidersByName(String key) {
    return providerRepository.searchByName(key);
}

 /**
   * Method to get providers by city
   *
   * @param city The city to search for
   * @return List of providers with the specified city
   */
    public Object getProvidersByCity(String city){
        return providerRepository.getProvidersByCity(city);
    }

     /**
   * Method to add a new provider
   *
   * @param provider The provider to add
   * @return List of all providers
   */
    public Object addProvider(Provider provider){
        return providerRepository.save(provider);
    }

    /**
   * Method to update a provider
   *
   * @param provider The provider to update
   * @return List of all providers
   */
    public Object updateProvider(Provider provider){
        return providerRepository.save(provider);
    }


     /**
   * Method to delete a provider by ID
   *
   * @param providerId The ID of the provider to delete
   * @return List of all providers
   */
    public Object deleteProvider(Long providerId){
      providerRepository.deleteById(providerId);
        return providerRepository.findAll();
    }

 /**
   * Method to get statistics for a provider by their ID
   *
   * @param providerId The ID of the provider to retrieve statistics for
   * @return A map containing the number of services and bookings for the provider
   */

   public Object getStatsByProviderId(Long providerId){
      Map<String, Object> result = new HashMap<>();

    try {
        List<ServiceEntity> services = serviceService.getServicesByProviderId(providerId);
        if (services == null) {
            System.out.println("No services found for providerId: " + providerId);
            result.put("error", "No services found");
            return result;
        }

        int bookingCount = 0;
        int repeatingServices = 0;

        for (ServiceEntity service : services) {
            int serviceBookingCount = bookingService.getBookingsByServiceId(service.getServiceId()).size();
            bookingCount += serviceBookingCount;
            if (serviceBookingCount > 1) {
                repeatingServices++;
            }
        }

        result.put("serviceCount", services.size());
        result.put("totalBookings", bookingCount);
        result.put("repeatingServices", repeatingServices);
        return result;

    } catch (Exception e) {
        e.printStackTrace(); // Print the error in your console
        result.put("error", "An error occurred: " + e.getMessage());
        return result;
    }
   } 




}
