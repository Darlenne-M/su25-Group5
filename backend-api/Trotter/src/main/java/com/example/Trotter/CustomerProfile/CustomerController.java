package com.example.Trotter.CustomerProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

   // @SuppressWarnings("rawtypes")
    @Autowired
    private CustomerService customerService;

    /**
     * Endpoing to get all customers
     * 
     * @return List of all customers
     */
    @GetMapping("/customers")
    public Object getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Endpoint to get a customer by ID
     * 
     * @param id The Id of the customer to retrieve
     * @return The customer with the unique ID
     */
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Endpoint to get customers by name
     * 
     * @param name The name of the customer to search for
     * @return List of customers with their unique name
     */
    @GetMapping("/customers/name")
    public Object getCustomersByName(@RequestParam String key) {
        if (key != null) {
            return customerService.getCustomersByName(key);
            } else {
            return customerService.getAllCustomers();
        }
    }

    /**
     * Endpoint to add a new customer
     * 
     * @param customer The customer to add
     * @return List of all customers
     */
    @PostMapping("/customers")
    public Object addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    /**
     * Endpoint to update a customer
     * 
     * @param customer The customer to update
     * @return List of all customers
     */
    @PutMapping("/customers/{customerId}")
    public Object updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customer,customerId);
        return customerService.getCustomerById(customerId);
    }


    /**
     * Endpoint to delete a customer by ID
     * 
     * @param id The ID of the customer to delete
     * @return List of all customers
     */
    @DeleteMapping("/customers/{id}")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return customerService.getAllCustomers();
    }

    /**Endpoint to write a customer to JSON file
     * 
     * @param customer The customer to write
     * @ return An empty string indicating success
     */

     @PostMapping("/customers/writeFile")
     public Object writeJson(@RequestBody Customer customer) {
        customerService.writeJson(customer);
        return customerService.writeJson(customer);
     }

     /**
      * Endpoint to read a JSON file and return its contents
      *
      *@return The contents of the JSON file
      */

      @PostMapping("customers/readFile")
      public Object readJson() {
          return customerService.readJson();
      }

     
}   
