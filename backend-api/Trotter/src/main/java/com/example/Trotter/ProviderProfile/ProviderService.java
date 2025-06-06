package com.example.Trotter.ProviderProfile;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderServices.ServiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Trotter.ProviderBookings.BookingService;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/profile-pictures/";

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private BookingService bookingService;

    /**
     * Method to get all providers
     *
     * @return List of all providers
     */
    public Object getAllProviders() {
        return providerRepository.findAll();
    }

    /**
     * Method to get a provider by ID
     *
     * @param providerId The ID of the provider to retrieve
     * @return The provider with the specified ID
     */

    public Provider getProviderById(@PathVariable long providerId) {
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
    public Object getProvidersByCity(String city) {
        return providerRepository.getProvidersByCity(city);
    }

    /**
     * Method to add a new provider
     *
     * @param provider The provider to add
     * @return List of all providers
     */
    public Provider addProvider(Provider provider, MultipartFile profilePicture) {
        Provider newProvider = providerRepository.save(provider);
        String originalFileName = profilePicture.getOriginalFilename();

        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(newProvider.getProviderId()) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                InputStream inputStream = profilePicture.getInputStream();
                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath,
                        StandardCopyOption.REPLACE_EXISTING);
                newProvider.setProfilePicturePath(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providerRepository.save(newProvider);
    }

    /**
     * Method to update a provider
     *
     * @param provider The provider to update
     * @return List of all providers
     */
    public Provider updateProvider(Long providerId, Provider provider, MultipartFile profilePicture) {
        String originalFileName = profilePicture.getOriginalFilename();
        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(providerId) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = profilePicture.getInputStream();
                Files.deleteIfExists(filePath);
                Files.copy(inputStream, filePath,
                StandardCopyOption.REPLACE_EXISTING);// Save file
                provider.setProfilePicturePath(fileName);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return providerRepository.save(provider);
    }

    /**
     * Method to delete a provider by ID
     *
     * @param providerId The ID of the provider to delete
     * @return List of all providers
     */
    public void deleteProvider(Long providerId) {
        Provider provider = providerRepository.findById(providerId).orElse(null);
        if(provider == null){
            return; //provider not found, nothing to delete
        }
        Path filePath = Paths.get(UPLOAD_DIR + provider.getProfilePicturePath());
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        providerRepository.deleteById(providerId);
    }

    /**
     * Method to get statistics for a provider by their ID
     *
     * @param providerId The ID of the provider to retrieve statistics for
     * @return A map containing the number of services and bookings for the provider
     */

    public Object getStatsByProviderId(Long providerId) {
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

    public String writeJson(Provider provider){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("providers.json"), provider);
            return "Provider written to JSON file successfully";
        }catch (IOException e) {
            e.printStackTrace();
            return "Error writing provider to JSON file";
        }
    }

    public Object readJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File("providers.json"),Provider.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
