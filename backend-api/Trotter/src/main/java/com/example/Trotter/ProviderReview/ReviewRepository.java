package com.example.Trotter.ProviderReview;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select * from reviews r where r.provider_id = ?1", nativeQuery = true)
    List<Review> getReviewsByProviderId(Long providerId);
    
    @Query(value = "select * from reviews r where r.service_id = ?1", nativeQuery = true)
    List<Review> getReviewsByServiceId(Long serviceId);

   
    
    
}
