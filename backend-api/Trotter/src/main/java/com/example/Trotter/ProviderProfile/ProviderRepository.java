package com.example.Trotter.ProviderProfile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
    @Query("SELECT p FROM Provider p WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :key, '%')) OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Provider> searchByName(@Param("key") String key);

    List<Provider> getProvidersByCity(String city);

    Optional<Provider> getProviderByEmail(String username);
}
