package com.example.Trotter.ProviderReplies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

        @Query(value = "select * from replies r where r.provider_id = ?1", nativeQuery = true)
        List<Reply> getRepliesByProviderId(Long providerId);
        
        @Query(value = "select * from replies r where r.service_id = ?1", nativeQuery = true)
        List<Reply> getRepliesByServiceId(Long serviceId);
        
         
        @Query(value = "select * from replies r where r.review_id = ?1", nativeQuery = true)
        List<Reply> getRepliesByReviewId(Long reviewId);
        
    
}


