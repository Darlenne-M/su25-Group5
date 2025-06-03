package com.example.Trotter.ProviderServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    List<Service> getServicesByServiceName(String name);

    @Query(value = "select * from services s where c.provider_id = ?1 providerId", nativeQuery = true)
        List<Service> getServicesByProviderId(long providerId);
    
}
