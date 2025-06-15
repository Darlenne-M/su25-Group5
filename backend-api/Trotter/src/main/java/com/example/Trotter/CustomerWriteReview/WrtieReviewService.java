package com.example.Trotter.CustomerWriteReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WrtieReviewService {
    
    public Object getAllReviews;
    @Autowired
    private WrtieReviewRepository reviewRepository;

    /**
     * Mehtod to get all reviews
     *
     * @return List of all reviews
     */
    public Object getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Method to get a review by Id
     * 
     * @param reviewId The Id of review to get
     * @return The review with the specific Id
     */
    public WriteReview getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    /**
     * Method to get reviews by provider Id
     * 
     * @param providerId The Id of the provider to search
     * @return List of revies for the specified provider
     */
    public Object getReviewsByProviderId(Long providerId) {
        return reviewRepository.getReviewsByProviderId(providerId);
    }

    /**
     * Method to get reviews by service Id
     * 
     * @param serviceId The Id of the service being searched for
     * @return List of reviews for the specific service
     */
    public List<WriteReview> getReviewsByServiceId(Long serviceId) {
        return reviewRepository.getReviewsByServiceId(serviceId);
    }

    /**
     * Method to add a new review
     * 
     * @param review The review to add
     * @return List of all reviews
     */
    public Object addReview(WriteReview review) {
        return reviewRepository.save(review);
    }

    /**
     * 
     * Mehtod to update review
     * 
     * @param review The review being updated
     * @return List of all reviews
     */
    public Object updateReview(WriteReview review) {
        return reviewRepository.save(review);
    }

    /**
     * Method to delete a review by Id
     * 
     * @param reviewId The Id of the review to be deleted
     */
    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
