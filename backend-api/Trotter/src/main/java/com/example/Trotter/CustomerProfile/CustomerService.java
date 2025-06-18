package com.example.Trotter.CustomerProfile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    //@Autowired// on the constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } 
    
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

    public Object getCustomersByName(String key) {
        return customerRepository.searchByName(key);
    }

    /**
     * Method to add a new customer
     * 
     * @param customer The customer to add
     * @return List of all customers
     */
    public Customer addCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    /**
     * Method to get providers by city
     * 
     * @param city The city to search
     * @return List of providers within a city
     */
    //public String getProvidersByCity(String city) {
        //return customerRepository.getProvidersByCity(city);
   // }

    /**
     * Method to update a customer
     * 
     * @param customer The customer to update
     * @return List of all customers
     */
    public Customer updateCustomer(Customer customer, Long customerId) {
         Optional<Customer> existingCustomerOptional = customerRepository.findById(customerId);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();

            // 2. Update fields of the existing customer with values from the provided 'customer' object.
            //    Only update if the incoming value is not null, to preserve existing data for unprovided fields.

            if (customer.getFirstName() != null) {
                existingCustomer.setFirstName(customer.getFirstName());
            }
            if (customer.getLastName() != null) {
                existingCustomer.setLastName(customer.getLastName());
            }
            if (customer.getAddress() != null) {
                existingCustomer.setAddress(customer.getAddress());
            }
            if (customer.getCity() != null) {
                existingCustomer.setCity(customer.getCity());
            }
            if (customer.getState() != null) {
                existingCustomer.setState(customer.getState());
            }
            if (customer.getZip() != null) {
                existingCustomer.setZip(customer.getZip());
            }
            if (customer.getPhone() != null) {
                existingCustomer.setPhone(customer.getPhone());
            }
            if (customer.getEmail() != null) {
                existingCustomer.setEmail(customer.getEmail());
            }
            if (customer.getPasswordString() != null) { // Assuming getPasswordString() is the getter for 'password'
                existingCustomer.setPassword(customer.getPasswordString());
            }

            if (customer.getprofilePicture() != null) {
                existingCustomer.setProfilePicture(customer.getprofilePicture());
            }
            if (customer.getRole() != null) {
                existingCustomer.setRole(customer.getRole());
            }
       return customerRepository.save(existingCustomer);
     } else {
        return null;
     }
    }

    /**
     * Method to delete a customer by ID
     * 
     * @param customerId The Id of the customer to delete
     * @return List of all customers
     */
    public void deleteCustomer(Long CustomerId) {
       customerRepository.deleteById(CustomerId);
    }

    /**
     * Method to write a customer object to a JSON file
     * 
     * @param customer The customer object to write
     * 
     */
    public String writeJson(Customer customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("customers.json"), customer);
            return "Customer written to JSON file sucessfully";
            } catch (IOException e) {
            e.printStackTrace();
            return "Error writting customer to JSON file";
        }
    }

    /**
     * Method to read a customer object to a JSON file
     * 
     * @param customer The customer object to read 
     *
     */
    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("customer.json"), Customer.class);
            } catch (IOException e) {
           e.printStackTrace(); 
           return null;    
        }
    }

    /**
     * Method to get stats for a customer by ID
     * 
     * @param customerId The ID fo the customer to look up stats on
     * @return Map that contains the number of bookings and reviews for the customer
     */
    public Map<String, Object> getStatsByCustomerId(Long customerId) {
        Map<String, Object> result = new HashMap<>();
        try {
            //Example: get bookings and reviews count
            //int bookings = bookingService.countBookingsByCustomerId(customerId);
            //int reviews = bookingService.countReviewsByCustomerId(customerId);
            //result.put("bookings", bookings);
            //result.put("reviews", reviews);
        } catch (Exception e) {
            result.put("error","An error occurred: " + e.getMessage());
        }
        return result;
    }

}
