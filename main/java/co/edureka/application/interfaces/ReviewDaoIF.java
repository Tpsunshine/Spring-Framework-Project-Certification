package co.edureka.application.interfaces;

import java.util.HashMap;
import java.util.List;

import co.edureka.application.model.Review;
import co.edureka.application.model.ReviewDetails;

public interface ReviewDaoIF {

	List<ReviewDetails> retrieveReviewDetails(Integer reviewId);

	void addLikes(Integer reviewId);

	ReviewDetails addReview(Integer partyId, Integer bookId, Review review);

	List<ReviewDetails> findRecentReviews();
	
	List<ReviewDetails> findRecentReviewsOfUser(int userId);

	HashMap<String, Object>  viewReview(Integer bookId);
}
