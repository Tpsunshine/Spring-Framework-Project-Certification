package co.edureka.application.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import co.edureka.application.interfaces.BookDaoIF;
import co.edureka.application.interfaces.PartyDaoIF;
import co.edureka.application.interfaces.ReviewDaoIF;
import co.edureka.application.model.Book;
import co.edureka.application.model.Party;
import co.edureka.application.model.Review;
import co.edureka.application.model.ReviewDetails;

@RestController
@RequestMapping("/account")
@SessionAttributes({"partyId","partyName"})
public class PartyController {

	@Autowired
	private PartyDaoIF partyDaoIF;
	
	@Autowired
	private BookDaoIF bookDaoIF;
	
	@Autowired
	private ReviewDaoIF reviewDaoIF;

	@GetMapping("/signin")
	public ModelAndView retrieveLoginPage() {
		ModelAndView mav = new ModelAndView();
		//mav.addObject("party", new Party());
		//mav.addObject("password", new String());
		mav.setViewName("login");
		return mav;
		//return "login";

	}

	//@RequestMapping("/login/{userId}/{password}")
//	public ModelAndView modifyLogin(@PathVariable("userId") Integer userId,
//			@PathVariable("password") String password) {
	
	@RequestMapping("/login")
	public ModelAndView modifylogin(@RequestParam(value ="userId") String userId, @RequestParam(value ="password") String password, Model model) {
		ModelAndView mav =new ModelAndView();
		int userId1 = Integer.parseInt(userId);
		Party party = partyDaoIF.retrieveLoginDetails(userId1, password);
//		List<Book> books = new ArrayList<>();
//		books = bookDaoIF.retrieveDefaultBooks();
//		//reviews = reviewDaoIF.retrieveReviewBasedOnBookId(books.get(0).get)
//		mav.addObject("firstName", party.getFirstName());
		model.addAttribute("partyId", party.getPartyId());
		model.addAttribute("partyName", party.getFirstName());
		mav.addObject(model);
		List<ReviewDetails> reviewDetailsRecent = reviewDaoIF.findRecentReviews();
		List<ReviewDetails> recentReviewDetilsOfParty = new ArrayList<>();
		ReviewDetails reviewDetails = new ReviewDetails();
		reviewDetails.setParty(new Party());
		reviewDetails.setReview(new Review());
		
		reviewDetails.setBook(new Book());
		recentReviewDetilsOfParty.add(reviewDetails);
		mav.addObject("party", party);
		mav.addObject("reviewDetails", reviewDetailsRecent);
		mav.addObject("reviewDetailsParty", reviewDetailsRecent);
		mav.setViewName("home");
		
		return mav;
		//return "Hello" + party.getFirstName();

	}

	
	@GetMapping("/signup")
	public ModelAndView retrieveSignUp() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("party", new Party());
		mav.addObject("password", new String());
		mav.setViewName("registration");
		return mav;
	}
	
	//
	//@PostMapping("/registration/{password}")
	//@PostMapping("/registration")
	@RequestMapping("/registration")
	@ResponseBody
	public ModelAndView modifyRegistration(@ModelAttribute("party") Party party, Model model) {
		party.setGender("M");
		Party newParty = partyDaoIF.modifyRegistration(party, party.getPassword());
		System.out.println(newParty);
		String message = "Your login id is: "+ newParty.getUserId();
		List<ReviewDetails> reviewDetailsRecent = reviewDaoIF.findRecentReviews();
		List<ReviewDetails> recentReviewDetilsOfParty = reviewDaoIF.findRecentReviewsOfUser(newParty.getUserId());
		ModelAndView mav =new ModelAndView();
		model.addAttribute("partyId", newParty.getPartyId());
		model.addAttribute("partyName", newParty.getFirstName());
		mav.addObject("message", message);
		mav.addObject("party", newParty);
		mav.addObject("reviewDetails", reviewDetailsRecent);
		mav.addObject("reviewDetailsParty", recentReviewDetilsOfParty);
		mav.setViewName("home");
		
		return mav;
		
	}
	
	@GetMapping("/home/{partyId}")
	public ModelAndView retrieveHome(@PathVariable("partyId") Integer partyId) {
		Party party = partyDaoIF.retrievePartyDetails(partyId);
		List<ReviewDetails> reviewDetailsRecent = reviewDaoIF.findRecentReviews();
		List<ReviewDetails> recentReviewDetilsOfParty = reviewDaoIF.findRecentReviewsOfUser(party.getUserId());
		ModelAndView mav =new ModelAndView();
		mav.addObject("party", party);
		mav.addObject("reviewDetails", reviewDetailsRecent);
		mav.addObject("reviewDetailsParty", recentReviewDetilsOfParty);
		mav.setViewName("home");
		
		return mav;
		
	}

	@GetMapping("/logout/{partyId}")
	public ModelAndView logoutSession(@PathVariable("partyId") Integer partyId, Model model) {
		System.out.println("***************");
		ModelAndView mav =new ModelAndView();
		model.addAttribute("partyId", null);
		model.addAttribute("partyName", null);
		
		mav.setViewName("default");
		return mav;
	}
}
