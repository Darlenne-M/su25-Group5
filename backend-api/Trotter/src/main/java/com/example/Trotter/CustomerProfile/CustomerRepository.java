package com.example.Trotter.CustomerProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // T = Customer (entity class)
    // ID = Long (the type of your entity's ID)

    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstname) LIKE LOWER (CONCAT('%', :key, '%'))OR LOWER(c.lastName)LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Customer> searchByName(@Param("key") String key);
    
    List<Customer> getProvidersByCity(String city);

    List<Customer> getAllCustomers(String CustomerRepository);
}
