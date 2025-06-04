package com.example.Trotter.ProviderReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

      /**
   * Endpoint to get all reviews
   *
   * @return List of all reviews
   */
    @GetMapping("/reviews")
    public Object getAllReviews(){
       return reviewService.getAllReviews();
    }

    /**
   * Endpoint to get a review by ID
   *
   * @param id The ID of the review to retrieve
   * @return The review with the specified ID
   */
    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }

      /**
   * Endpoint to get all reviews for a specific provider
   *
   * @param providerId The ID of the provider to search for
   * @return List of reviews for the specified provider
   */
    @GetMapping("/reviews/provider/{providerId}")
    public Object getReviewsByProviderId(@PathVariable Long providerId){
        return reviewService.getReviewsByProviderId(providerId);
    }

      /**
   * Endpoint to get all reviews for a specific service
   *
   * @param serviceId The ID of the service to search for
   * @return List of reviews for the specified service
   */
    @GetMapping("/reviews/service/{serviceId}")
    public Object getReviewsByServiceId(@PathVariable Long serviceId){
        return reviewService.getReviewsByServiceId(serviceId);
    }

      /**
   * Endpoint to add a new review
   *
   * @param review The review to add
   * @return List of all reviews
   */
    @PostMapping("/reviews")
    public Object addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }

      /**
   * Endpoint to delete a review by ID
   *
   * @param id The ID of the review to delete
   */
    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReviewById(id);
    }

      /**
   * Endpoint to update a review
   *
   * @param id           The ID of the review to update
   * @param review The updated review information
   * @return The updated review
   */
    @PutMapping("/reviews/{id}")
    public Object updateReview(@PathVariable Long id, @RequestBody Review review){
        review.setReviewId(id); // Ensure the ID is set for the update
        return reviewService.updateReview(review);
    }






}
