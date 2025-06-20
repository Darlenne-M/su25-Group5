package com.example.Trotter.ProviderProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import com.example.Trotter.ProviderProfile.Provider;//*edit-ser */

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
    @Query("SELECT p FROM Provider p WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :key, '%')) OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Provider> searchByName(@Param("key") String key);

    List<Provider> getProvidersByCity(String city);
}
