package com.example.Trotter.ProviderServices;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Path;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/profile-pictures/";

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

   public ServiceEntity getServiceById(@PathVariable long serviceId){
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
   public ServiceEntity addService(ServiceEntity service, MultipartFile image){
        ServiceEntity newService = serviceRepository.save(service);
        String originalFileName = image.getOriginalFilename();

    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(newService.getServiceId()) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = image.getInputStream();

        Files.createDirectories(Paths.get(UPLOAD_DIR));// Ensure directory exists
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save file
        newService.setImagePath(fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return serviceRepository.save(newService);
   }

    /**
   * Method to update a service
   *
   * @param service The service to update
   * @return List of all services
   */
   public ServiceEntity updateService(Long serviceId, ServiceEntity service, MultipartFile image){
        String originalFileName = image.getOriginalFilename();

    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(serviceId) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = image.getInputStream();
        Files.deleteIfExists(filePath);
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save file
        service.setImagePath(fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return serviceRepository.save(service);
   }

     /**
   * Method to delete a service by ID
   *
   * @param serviceId The ID of the service to delete
   * @return List of all services after deletion
   */
   public void deleteServiceById(Long serviceId){
    ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);
    if(service == null){
        return;
    }
    Path filePath = Paths.get(UPLOAD_DIR + service.getImagePath());
    try{
      Files.deleteIfExists(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    serviceRepository.deleteById(serviceId);
   }

   public List<ServiceEntity> getServicesByProviderId(Long providerId){
    return serviceRepository.getServicesByProviderId(providerId);
   }

   public String writeJson(ServiceEntity service) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("services.json"), service);
      return "Service written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing service to JSON file";
    }

  }

  /**
   * Method to read a student object from a JSON file
   *
   * @return The student object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("services.json"), ServiceEntity.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

}
