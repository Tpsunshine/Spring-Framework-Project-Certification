package co.edureka.application.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import co.edureka.application.interfaces.ReviewDaoIF;
import co.edureka.application.model.Review;
import co.edureka.application.model.ReviewDetails;

@RestController
@RequestMapping("/reviews")
@SessionAttributes({"partyId","partyName"})
public class ReviewController {
	
	@Autowired
	private ReviewDaoIF reviewDaoIF;

	/*
	  @RequestMapping("/{reviewId}")
	 
	public ModelAndView retrieveReviewList(@PathVariable("reviewId") Integer reviewId) {
		ModelAndView mav =new ModelAndView();
		
		App app = reviewDaoIF.retrieveReviewDetails(reviewId);
		
		return app;
	}*/
	
//	@GetMapping("/{reviewId}/likes")
//	public App incrementLikes(@PathVariable("reviewId") Integer reviewId) {
//		reviewDaoIF.addLikes(reviewId);
//		App app = null;
//		return app;
//	}
	
	@PostMapping("/{partyId}/{bookId}/addReview")
	public ModelAndView addReview(@PathVariable("partyId") Integer partyId, @PathVariable("bookId") Integer bookId, @ModelAttribute("review") Review review, Model model) {
		ModelAndView mav =new ModelAndView();
		model.addAttribute("partyId", partyId);
		ReviewDetails reviewDetailsLatest = reviewDaoIF.addReview(partyId, bookId, review);
		
		mav.addObject("partyId", partyId);
		mav.addObject("reviewDetails", reviewDetailsLatest);
		mav.setViewName("recentReview");
		return mav;
		
		
	}
	
	
	
	@GetMapping("/viewReview")
	public ModelAndView viewReview(@RequestParam(value ="bookId") Integer bookId) {
		System.out.println(bookId);
		HashMap<String, Object> map = reviewDaoIF.viewReview(bookId);
		ModelAndView mav =new ModelAndView();
		
		mav.addObject("book", map.get("book"));
		mav.addObject("reviewDetails", map.get("revDetails"));
		mav.setViewName("reviewTable");
		return mav;
		
		
	}
}
