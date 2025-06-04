package com.example.Trotter.ProviderReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    /**
   * Method to get all reviews
   *
   * @return List of all reviews
   */
    public Object getAllReviews(){
        return reviewRepository.findAll();
    }

      /**
   * Method to get a review by ID
   *
   * @param reviewId The ID of the review to retrieve
   * @return The review with the specified ID
   */
    public Review getReviewById(Long reviewId){
        return reviewRepository.findById(reviewId).orElse(null);
    }

     /**
   * Method to get reviews by provider ID
   *
   * @param providerId The ID of the provider to search for
   * @return List of reviews for the specified provider
   */
    public Object getReviewsByProviderId(Long providerId){
        return reviewRepository.getReviewsByProviderId(providerId);
    }

      /**
   * Method to get reviews by service ID
   *
   * @param serviceId The ID of the service to search for
   * @return List of reviews for the specified service
   */
    public List<Review> getReviewsByServiceId(Long serviceId){
        return reviewRepository.getReviewsByServiceId(serviceId);
    }

      /**
   * Method to add a new review
   *
   * @param review The review to add
   * @return List of all reviews
   */
  public Object addReview(Review review){
    return reviewRepository.save(review);
  }

    /**
   * Method to update a review
   *
   * @param review The review to update
   * @return List of all reviews
   */
  public Object updateReview(Review review){
    return reviewRepository.save(review);
  }

    /**
   * Method to delete a review by ID
   *
   * @param reviewId The ID of the review to delete
   */
  public void deleteReviewById(Long reviewId){
    reviewRepository.deleteById(reviewId);
  }
}
