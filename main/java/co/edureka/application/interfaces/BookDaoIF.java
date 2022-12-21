package co.edureka.application.interfaces;

import java.util.List;

import org.springframework.context.annotation.Bean;

import co.edureka.application.model.Book;


public interface BookDaoIF {

	//@Bean
	List<Book> retrieveDefaultBooks();

	Book retrieveBook(Integer partyId, Integer bookId);

	List<Book> searchBook(String search, int reviewCount);

	Book addBookInDB(int partyId, Book book);
	
}
