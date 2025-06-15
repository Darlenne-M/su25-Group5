package com.example.Trotter.CustomerProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trotter.CustomerViewServices.ViewServices;
import com.example.Trotter.ProviderBookings.BookingService;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Constructor
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } 
    
    @Autowired
    private BookingService viewService;

    @SuppressWarnings("unused")
    @Autowired
    private BookingService bookingService;

    

    /**
     * Method to get all customers
     * 
     * @return List of all customers
     */
    public Object getAllCustomers() {
    return customerRepository.findAll();
    }

    /**
     *Method to get a customer by ID 
     *
     * @param customerId The Id of the customer to get
     * @return The customer with unique ID
     */
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    /**
     * Method to get customers by name
     * 
     * @param name The name of the customer to search
     * @return The List of customers with unique name
     */

    public List<Customer> getCustomersByName(String key) {
        return customerRepository.searchByName(key);
    }

    /**
     * Method to add a new customer
     * 
     * @param customer The customer to add
     * @return List of all customers
     */
    public Object addCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    /**
     * Method to get providers by city
     * 
     * @param city The city to search
     * @return List of providers within a city
     */
    public Object getProvidersByCity(String city) {
        return customerRepository.getProvidersByCity(city);
    }

    /**
     * Method to update a customer
     * 
     * @param customer The customer to update
     * @return List of all customers
     */
    public Object updateCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    /**
     * Method to delete a customer by ID
     * 
     * @param customerId The Id of the customer to delete
     * @return List of all customers
     */
    public Object deleteCustomer(Long CustomerId) {
        return customerRepository.findAll();
    }

    /**
     * Method to get stats for a customer by ID
     * 
     * @param customerId The ID fo the customer to look up stats on
     * @return Map that contains the number of bookings and reviews for the customer
     */
    public Object getStatsByCustomerId(Long customerId) {
        Map<String, Object> result = new HashMap<>();
    String providerId = null;
    
         try {
        List<ViewServices> services = viewService.getServiceByCustomerId(customerId);
        if (services == null) {
            System.out.println("No services found for providerId: " + providerId);
            result.put("error", "No services found");
            return result;
        }
    }catch(Exception e){
         e.printStackTrace(); // Print the error in your console
        result.put("error", "An error occurred: " + e.getMessage());
        return result;
    }
         return providerId;

    }
    
}
