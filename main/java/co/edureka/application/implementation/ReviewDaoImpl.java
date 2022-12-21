package co.edureka.application.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edureka.application.interfaces.ReviewDaoIF;
import co.edureka.application.model.Book;
import co.edureka.application.model.Review;
import co.edureka.application.model.ReviewDetails;
import co.edureka.application.repository.BookRepository;
import co.edureka.application.repository.PartyRepository;
import co.edureka.application.repository.ReviewRepository;

@Service
@Transactional
public class ReviewDaoImpl implements ReviewDaoIF {

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private BookRepository bookRepo;
	/*
	@Override
	public List<ReviewDetails> retrieveReviewDetails(Integer reviewId) {
		Optional<Party> party = null;;
		Optional<Book> book = null;
		Optional<Review> review = reviewRepo.findById(reviewId);
		if(review.isPresent()) {
			 party = partyRepo.findById(review.get().getPartyId());
			 book = bookRepo.findById(review.get().getBookId());
		}
		
		ReviewDetails reviewDetails = new ReviewDetails();
		List<Review> reviews = new ArrayList<>();
		reviews.add(review.get());
		reviewDetails.setReviews(reviews);
		
		List<Book> books = new ArrayList<Book>();
		books.add(book.get());
		reviewDetails.setBooks(books);
		
		reviewDetails.setParty(party.get());
		return reviewDetails;
	}
*/
	public void addLikes(Integer reviewId) {
		reviewRepo.updateLikes(reviewId);
		
	}

	
	public ReviewDetails addReview(Integer partyId, Integer bookId, Review review) {
		review.setPartyId(partyId);
		review.setBookId(bookId);
		review.setLikes(0);
		Date postedOn = new Date();
		review.setPostedOn(postedOn);
		//review.setReviewId(2006);
		System.out.println(review);
		Review newReview = reviewRepo.save(review);
		System.out.println(newReview);
		ReviewDetails reviewDetails = new ReviewDetails();
		
		
		//update reviewCount for bookId
		
		// bookRepo.addReviewCount(bookId);
		System.out.println(bookId);
		 Optional<Book> book = bookRepo.findById(bookId);
		System.out.println(book);
		reviewDetails.setReview(newReview);
		reviewDetails.setBook(book.get());
		//bookRepo.findById(bookId);
		return reviewDetails;
	}
	
	public List<Review> findReviewsBasedOnBookId(int bookId){
		
		List<Review> reviews = reviewRepo.fetchReviewsByBookId(bookId);
		Iterator<Review> iterator = reviews.iterator();
		//for(Review review : iterator.hasNext()) {
			
		//}
//		for(Review review : reviews) {
//			Optional<Party> party = partyRepo.findById(review.getPartyId());
//			review.setParty(party.get());
//		}
		
		return null;
	}
	

	public List<ReviewDetails> findRecentReviews() {
		List<ReviewDetails> reviewsList =new ArrayList<ReviewDetails>();
		ReviewDetails reviewDetails = new ReviewDetails();
		
		List<Review> reviews = reviewRepo.fetchRecentReviews();
		//for(Review review : reviews) {
			reviewDetails.setReview(reviews.get(0));
			reviewDetails.setBook(bookRepo.findById(reviews.get(0).getBookId()).get());
			System.out.println(reviews.get(0).getPartyId());
			
			reviewDetails.setParty(partyRepo.fetchPartyDetails(reviews.get(0).getPartyId()));
			//reviewDetails.setParty(partyRepo.findById(1235).get());
			reviewsList.add(reviewDetails);
		//}
		
		return reviewsList;
	}
	
	public List<ReviewDetails> findRecentReviewsOfUser(int userId) {
		List<ReviewDetails> reviewsList =new ArrayList<ReviewDetails>();
		ReviewDetails reviewDetails = new ReviewDetails();
		
		int party_Id = partyRepo.findPartyByUserId(userId);
		
		List<Review> reviews = reviewRepo.findReviewBasedOnPartyId(party_Id);
		//for(Review review : reviews) {
			//reviewDetails.setParty(party);
			reviewDetails.setReview(reviews.get(0));
			reviewDetails.setBook(bookRepo.findById(reviews.get(0).getBookId()).get());
			reviewsList.add(reviewDetails);
		//}
		
		return reviewsList;
	}

	@Override
	public HashMap<String, Object>  viewReview(Integer bookId) {
		List<ReviewDetails> reviewDetailsList = new ArrayList<ReviewDetails>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(bookId);
		List<Review> reviews = reviewRepo.findByBookId(bookId);
		for(Review review :reviews) {
			ReviewDetails reviewDetails = new ReviewDetails();
			reviewDetails.setReview(review);
			System.out.println(review.getPartyId());
			reviewDetails.setParty(partyRepo.fetchPartyDetails(review.getPartyId()));
			reviewDetailsList.add(reviewDetails);
		}
		
		Optional<Book> books = bookRepo.findById(bookId);
		map.put("book", books.get());
		map.put("revDetails", reviewDetailsList);
		return map;
	}


	@Override
	public List<ReviewDetails> retrieveReviewDetails(Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}
}
