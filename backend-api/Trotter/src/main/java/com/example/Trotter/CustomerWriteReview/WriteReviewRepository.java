package com.example.Trotter.CustomerWriteReview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WriteReviewRepository extends JpaRepository<WriteReview, Long> {
    @Query(value = "select * from reviews r where r.provider_id =?1", nativeQuery = true)
    List<WriteReview> getReviewsByProviderId(Long providerId);

    @Query(value = "select * from reviews r where r.service_id =?1", nativeQuery = true)
    List<WriteReview> getReviewsByService(Long serviceId);

    List<WriteReview> getReviewsByServiceId(Long serviceId);
    
}
