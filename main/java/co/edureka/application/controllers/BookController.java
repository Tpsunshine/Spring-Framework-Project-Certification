package co.edureka.application.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import co.edureka.application.interfaces.BookDaoIF;
import co.edureka.application.model.Book;
import co.edureka.application.model.Review;

@RestController
@SessionAttributes({"partyId","partyName"})
public class BookController {
	
	
	@Autowired
	private BookDaoIF bookDaoIF;
	
	@GetMapping({"/defaultBooks","/partyId/defaultBooks"})
	public List<Book> retrieveDefaultBooks(){
		List<Book> books = new ArrayList<>();
		books = bookDaoIF.retrieveDefaultBooks();
		return books;
		
		
	}
	
	@GetMapping("/{partyId}/{bookId}")
	public Book retrieveBook(@PathVariable("partyId") Integer partyId, @PathVariable("bookId") Integer bookId) {
		
		Book book = bookDaoIF.retrieveBook(partyId, bookId);
		return book;
	}
	
	@GetMapping("/searchBook")
	public ModelAndView searchBook(@RequestParam(value ="search") String search) {
				System.out.println(search);
		ModelAndView mav =new ModelAndView();
		int reviewCount = 0;
		List<Book> books = bookDaoIF.searchBook(search,reviewCount);
		
		mav.addObject("book", books);
		mav.setViewName("searchResult");
		return mav;
	}
		
	
	@GetMapping("/{partyId}/books")
	public ModelAndView addBook(@PathVariable("partyId") int partyId, Model model) {
		ModelAndView mav =new ModelAndView();
		model.addAttribute("partyId", partyId);
		System.out.println(model.getAttribute("partyId"));
		System.out.println(model.getAttribute("partyName"));
		model.addAttribute("search", new String());
		mav.addObject("partyId", partyId);
		mav.addObject("book", new Book());
		mav.setViewName("addBook");
		System.out.println("******************");
		return mav;
	}
		
	@PostMapping("/{partyId}/addBook")
	public ModelAndView addNewBook(@PathVariable("partyId") int partyId, @ModelAttribute("book") Book book, Model model) {
		ModelAndView mav =new ModelAndView();
		Book res = bookDaoIF.addBookInDB(partyId, book);
		mav.addObject("partyId", partyId);
		mav.addObject("review", new Review());
		mav.addObject("book", res);
		mav.setViewName("addReview");
		return mav;
	}

}

