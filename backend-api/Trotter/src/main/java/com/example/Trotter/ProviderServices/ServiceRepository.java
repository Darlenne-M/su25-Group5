package com.example.Trotter.ProviderServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long>{
    List<ServiceEntity> getServicesByServiceName(String name);

    @Query(value = "select * from services s where c.provider_id = ?1", nativeQuery = true)
        List<ServiceEntity> getServicesByProviderId(long providerId);
    
}
