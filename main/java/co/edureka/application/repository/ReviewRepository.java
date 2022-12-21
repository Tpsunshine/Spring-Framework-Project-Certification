package co.edureka.application.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edureka.application.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Serializable> {

	
	
	@Query(value = "select * from review_details where book_id = ?1", nativeQuery = true) 
	List<Review> fetchReviewsByBookId(@Param("book_Id") Integer bookId);

	//retrieve reviews based on posted_On
	@Query(value = "select * from review_details where posted_on ", nativeQuery = true) 
	List<Review> fetchRecentReviews();

	@Query(value = "select * from review_details where party_id=? and posted_on ", nativeQuery = true) 
	List<Review> findReviewBasedOnPartyId(@Param("party_Id")Integer partyId);

	
	@Query(value = "update review_details set likes = likes+1 where review_id=?1", nativeQuery = true)
	Review updateLikes(Integer reviewId);

	
	@Query(value = "select * from review_details where book_Id = ?1", nativeQuery = true)
	List<Review> findByBookId(@Param("book_Id") Integer bookId);
	
	
}
