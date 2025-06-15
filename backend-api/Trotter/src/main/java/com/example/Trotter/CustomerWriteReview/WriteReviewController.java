package com.example.Trotter.CustomerWriteReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteReviewController {
    @Autowired
    private WrtieReviewService reviewService;

    /**
     * Endpoint to get all revies
     * 
     * @return List of all reviews
     */
    @GetMapping("/reviews")
    public Object getAllReviews() {
        return reviewService.getAllReviews;
    }

    /**
     * Endpoints to get a review by Id
     * 
     * @param id The Id of review to get
     * @return The review with the specific Id
     */
    @GetMapping("/reviews/{id}")
    public WriteReview getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    /**
     * Endpoint to get all reviews for a specific provider
     * 
     * @param providerId The Id of the provider to search for
     * @return List of reviews for the specified provider
     */
    @GetMapping("/reviews/provider/{providerId}")
    public Object getReviewsByProviderId(@PathVariable Long providerId) {
        return reviewService.getReviewsByProviderId(providerId);
    }

    /**
     * Endpoint to get all reviews for a specific service
     * 
     * @param serviceId the Id of the service to search for
     * @return List of reviews for the specified service
     */
    @GetMapping("/reviews/service/{serviceId}")
    public Object getReviewsByServiceId(@PathVariable Long serviceId) {
        return reviewService.getReviewsByServiceId(serviceId);
    }

    /**
     * Endpoint to add a new review
     * 
     * @param review The review to add
     * @return List of all reviews
     */
    @PostMapping("/reviews")
    public Object addReview(@RequestBody WriteReview review) {
        return reviewService.addReview(review);
    }

    /**
     * Endpoint to delete a review by Id
     * 
     * @param id The Id of the review to delete
     */
    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }

    /**
     * Endpoint to update review
     * 
     * @param id The Id of the review being updated
     * @param reveiw The updated review 
     * @return Updated review
     */
    @PutMapping("/reviews/{id}")
    public Object updateReview(@PathVariable Long id, @RequestBody WriteReview review) {
        review.setReviewId(id, id);
        return reviewService.updateReview(review);
    }
}
