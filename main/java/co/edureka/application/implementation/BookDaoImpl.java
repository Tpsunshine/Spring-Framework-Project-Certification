package co.edureka.application.implementation;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edureka.application.interfaces.BookDaoIF;
import co.edureka.application.model.Book;
import co.edureka.application.repository.BookRepository;

@Service
@Transactional
public class BookDaoImpl implements BookDaoIF {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Book> retrieveDefaultBooks() {
		List<Book> book1= bookRepo.retrieveDefaultBooks();
		System.out.println(book1);
		return book1;
	}

	public Book retrieveBook(Integer partyId, Integer bookId) {
		Optional<Book> book = bookRepo.findById(bookId);
		Book newBook= new Book();
			//if(book.isPresent())
				//newBook = book;
		return newBook;
			//return newBook;
	}

	public List<Book> searchBook(String search, int reviewCount) {
		//SQLCustomQuery sql = new SQLCustomQuery(sqlQuery, queryReturns, additionalQuerySpaces, factory)
				
				
		String query = "select * from book_details where departments  like '%"+search+"%' or tag1 like '%"+search+"%' or tag2 like '%\"+search+\"%' or tag3 like '%\"+search+\"%' or book_name like '%"+search+"%' or author like '%"+search+"%' or publishers like '%"+search+"%'";
		System.out.println(query);
		
		List<Map<String, Object>> booksSearch = jdbcTemplate.queryForList(query);
		List<Book> books1 =new ArrayList<Book>();
		for(Map bookMap: booksSearch) {
			Book book = new Book();
		book.setBookId(Integer.parseInt(bookMap.get("book_id").toString()));
		book.setPartyId(Integer.parseInt(bookMap.get("party_id").toString()));
		book.setBookName(bookMap.get("book_name").toString());
		book.setAuthor(bookMap.get("author").toString());
		book.setDepartments(bookMap.get("departments").toString());
		book.setNoOfReview(Integer.parseInt(bookMap.get("NUMBERS_OF_REVIEW").toString()));
		book.setPublishers(bookMap.get("publishers").toString());
		books1.add(book);
		}
		return books1;
	}

	@Override
	public Book addBookInDB(int partyId, Book book) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		dateFormat.format(date);
		book.setPostedOn(date);
		book.setPartyId(partyId);
		book.setNoOfReview(0);
		Book newBook = bookRepo.save(book);
		return newBook;
	}

}
