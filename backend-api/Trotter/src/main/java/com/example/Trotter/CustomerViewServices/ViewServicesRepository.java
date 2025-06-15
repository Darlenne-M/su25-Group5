package com.example.Trotter.CustomerViewServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.OneToMany;

@Repository
public interface ViewServicesRepository extends JpaRepository<ViewServices, Long> {
    @OneToMany()
    List<ViewServices> getServiceByServiceName(String name);

    @Query(value = "select * from services s where c. provider_id = ?1", nativeQuery = true)
        List<ViewServices> getServicesByProviderId(Long providerId);

}
