package co.edureka.application.repository;

import java.io.Serializable;
import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edureka.application.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {

	@Query(value = "select * from book_details where departments = \"Friction\" or departments = \"Novel\" or departments = \"Sports\"", nativeQuery = true)
	List<Book> retrieveDefaultBooks();

//	@Query(value = "select * from book_details where departments  like '%asdf%' or tags like '%asdf%' or book_name like '%asdf%' or author like '%asdf%' or publishers like '%asdf%'", nativeQuery = true)
//	List<Book> searchBooks( String query);
//		
		
	//@Query(value= "select * from book_details where departments = \"asdf"\ or tags = \"asdf"\ or book_name = \"asdf"\ or author = \"asdf\" or publishers = \"asdf\"", nativeQuery = true)

	@Query(value = "select * from book_details where departments = \"asdf\" or tags = \"asdf\" or book_name = \"asdf\" or author = \"asdf\" or publishers = \"asdf\"", nativeQuery = true)
	List<Book> searchBooks();

	@Query(value = "update book_details set numbers_of_review = numbers_of_review+1 where book_id= ?", nativeQuery = true)
	 void addReviewCount(@Param("book_id")int bookId);
	
}
