package com.example.Trotter.ProviderReplies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * Endpoint to get all replies
     *
     * @return List of all replies
     */
    @GetMapping("/replies")
    public Object getAllReplies() {
        return replyService.getAllReplies();
    }

    
    /**
   * Endpoint to get a reply by ID
   *
   * @param id The ID of the reply to retrieve
   * @return The reply with the specified ID
   */
    @GetMapping("/replies/{id}")
    public Reply getReplyById(@PathVariable Long id){
        return replyService.getReplyById(id);
    }
          /**
   * Endpoint to get all replies for a specific provider
   *
   * @param providerId The ID of the provider to search for
   * @return List of replies for the specified provider
   */
    @GetMapping("/replies/provider/{providerId}")
    public Object getRepliesByProviderId(@PathVariable Long providerId){
        return replyService.getRepliesByProviderId(providerId);
    }

         /**
   * Endpoint to get all replies for a specific service
   *
   * @param serviceId The ID of the service to search for
   * @return List of replies for the specified service
   */
    @GetMapping("/replies/service/{serviceId}")
    public Object getRepliesByServiceId(@PathVariable Long serviceId){
        return replyService.getRepliesByServiceId(serviceId);
    }

            /**
   * Endpoint to get all replies for a specific review
   *
   * @param serviceId The ID of the review to search for
   * @return List of replies for the specified review
   */
    @GetMapping("/replies/review/{reviewId}")
    public Object getRepliesByReviewId(@PathVariable Long reviewId){
        return replyService.getRepliesByReviewId(reviewId);
    }
    
      /**
   * Endpoint to add a new reply
   *
   * @param reply The reply to add
   * @return List of all replies
   */
  @PostMapping("/replies")
  public Object addReply(@RequestBody Reply reply) {
    return replyService.addReply(reply);
  }

/**
   * Endpoint to delete a reply by ID
   *
   * @param id The ID of the reply to delete
   */
  @DeleteMapping("/replies/{id}")
  public void deleteReply(@PathVariable Long id) {
    replyService.deleteReplyById(id);
  }
    
    /**
   * Endpoint to update a reply
   *
   * @param id           The ID of the reply to update
   * @param reply The updated reply information
   * @return The updated reply
   */
   @PutMapping("/replies/{id}")
    public Object updateReply(@PathVariable Long id, @RequestBody Reply reply) {
    reply.setReplyId(id); // Ensure the ID is set for the update
    return replyService.updateReply(reply);
  }

}
