package co.edureka.application.model;

import java.beans.JavaBean;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "BOOK_DETAILS")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Integer bookId;
	@Column(name = "PARTY_ID")
	private Integer partyId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "PUBLISHERS")
	private String publishers;
	@Column(name = "POSTED_ON")
	private Date postedOn;
	
	@Column(name = "TAG1")
	private String tag1;
	@Column(name = "TAG2")
	private String tag2;
	@Column(name = "TAG3")
	private String tag3;
	@Column(name = "DEPARTMENTS")
	private String departments;
	@Column(name = "NUMBERS_OF_REVIEW")
	private Integer noOfReview;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	public String getTag3() {
		return tag3;
	}
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public Integer getNoOfReview() {
		return noOfReview;
	}
	public void setNoOfReview(Integer noOfReview) {
		this.noOfReview = noOfReview;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", partyId=" + partyId + ", bookName=" + bookName + ", author=" + author
				+ ", publishers=" + publishers + ", postedOn=" + postedOn + ", tag1=" + tag1 + ", tag2=" + tag2
				+ ", tag3=" + tag3 + ", departments=" + departments + ", noOfReview=" + noOfReview + "]";
	}
	
		
}
