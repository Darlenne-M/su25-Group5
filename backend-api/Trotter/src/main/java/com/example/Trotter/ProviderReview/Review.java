package com.example.Trotter.ProviderReview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderProfile.Provider;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne()
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Provider provider;

    @ManyToOne()
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties("provider")
    private ServiceEntity service;

    private String providerReply;

    public Review(){

    }

    public Review(Long reviewId, Provider provider, ServiceEntity service, String providerReply){
        this.reviewId = reviewId;
        this.provider = provider;
        this.service = service;
        this.providerReply = providerReply;
    }

      public Review(Provider provider, ServiceEntity service, String providerReply){
        this.provider = provider;
        this.service = service;
        this.providerReply = providerReply;
    }

    public Long getReviewId(){
        return reviewId;
    }

    public void setReviewId(Long reviewId){
        this.reviewId = reviewId;
    }
 
    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
    }

    public ServiceEntity getService(){
        return service;
    }
      
    public void setServiceId(ServiceEntity service){
        this.service = service;
    }
    
    public String getProviderRelpy(){
        return providerReply;
    }

    public void setProviderReply(String providerReply){
        this.providerReply = providerReply;
    }
        
    
}
