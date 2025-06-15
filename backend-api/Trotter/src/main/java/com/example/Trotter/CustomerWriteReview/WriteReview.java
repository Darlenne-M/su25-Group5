package com.example.Trotter.CustomerWriteReview;
import com.example.Trotter.CustomerProfile.Customer;
import com.example.Trotter.CustomerViewServices.ViewServices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class WriteReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Customer customer;

    @ManyToOne()
    private ViewServices service;
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnoreProperties("provider")
    

    private String customerWrtie;

    public WriteReview() {

    }

    @SuppressWarnings("unused")
    public WriteReview(Long reviewId, Customer customer, ViewServices service, String customerWrtie) {
        this.reviewId = reviewId;
        this.customer = customer;
        this.service = service;
        Object customerWrite = null;
    }

    WriteReview(Customer customer, ViewServices service, String customerWrite) {
        this.customer = customer;
        this.service = service;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long getReviewId, Long reviewId) {
        this.reviewId = reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ViewServices getService() {
        return service;
    }

    public void sertService(ViewServices service) {
        this.service = service;
    }

    public String getCustomerWrite() {
        return customerWrtie;
    }

    public void setCustomerWrtie(String customerWrite) {
        this.customerWrtie = customerWrite;
    }

}
