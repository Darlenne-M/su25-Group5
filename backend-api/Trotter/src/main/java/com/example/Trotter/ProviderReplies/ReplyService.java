package com.example.Trotter.ProviderReplies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    /**
     * Method to get all replies
     *
     * @return List of all replies
     */
    public Object getAllReplies() {
        return replyRepository.findAll();
    }

    /**
     * Method to get a reply by ID
     *
     * @param replyId The ID of the reply to retrieve
     * @return The reply with the specified ID
     */

    public Reply getReplyById(Long replyId) {
        return replyRepository.findById(replyId).orElse(null);
    }

    /**
     * Method to get replies by provider ID
     *
     * @param providerId The ID of the provider to search for
     * @return List of replies for the specified provider
     */
    public Object getRepliesByProviderId(Long providerId) {
        return replyRepository.getRepliesByProviderId(providerId);
    }

    /**
     * Method to get replies by service ID
     *
     * @param serviceId The ID of the service to search for
     * @return List of replies for the specified service
     */
    public List<Reply> getRepliesByServiceId(Long serviceId) {
        return replyRepository.getRepliesByServiceId(serviceId);
    }

    /**
     * Method to get replies by review ID
     *
     * @param reviewId The ID of the review
     * @return List of replies for the specified review
     */
    public List<Reply> getRepliesByReviewId(Long reviewId) {
        return replyRepository.getRepliesByReviewId(reviewId);
    }

    /**
     * Method to add a new reply
     *
     * @param reply The reply to add
     * @return List of all replies
     */
    public Object addReply(Reply reply) {
        return replyRepository.save(reply);
    }

    /**
     * Method to update a reply
     *
     * @param reply The reply to update
     * @return List of all replys
     */
    public Object updateReply(Reply reply) {
        return replyRepository.save(reply);
    }

    /**
     * Method to delete a reply by ID
     *
     * @param replyId The ID of the reply to delete
     */
    public void deleteReplyById(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}
