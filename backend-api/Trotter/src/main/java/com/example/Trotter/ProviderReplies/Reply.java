package com.example.Trotter.ProviderReplies;

import com.example.Trotter.ProviderProfile.Provider;
import com.example.Trotter.ProviderReview.Review;
import com.example.Trotter.ProviderServices.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "replies")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @ManyToOne()
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties("replies")
    private Provider provider;

    @ManyToOne()
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties("provider")
    private ServiceEntity service;

    @ManyToOne()
    @JsonIgnoreProperties({ "replies", "provider", "service" })
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @Column(nullable = false, length = 2000)
    private String replyText;

    public Reply() {
    }

    public Reply(Long replyId, Provider provider, ServiceEntity service, Review review, String replyText) {
        this.replyId = replyId;
        this.provider = provider;
        this.service = service;
        this.replyText = replyText;
        this.review = review;
    }

    public Reply(Provider provider, ServiceEntity service, Review review, String replyText) {
        this.provider = provider;
        this.service = service;
        this.replyText = replyText;
        this.review = review;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

}
