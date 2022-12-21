package co.edureka.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "REVIEW_DETAILS")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REVIEW_ID")
	private Integer reviewId;
	@Column(name = "PARTY_ID")
	private Integer partyId;
	@Column(name = "BOOK_ID")
	private Integer bookId;
	@Column(name = "LIKES")
	private Integer likes;
	@Column(name = "COMMENT")
	private String comment;
	@Column(name = "POSTED_ON")
	private Date postedOn;
	
//	/*
//	 * public Party getParty() { return party; } public void setParty(Party party) {
//	 * this.party = party; } private Party party;
//	 */
	
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", partyId=" + partyId + ", bookId=" + bookId + ", likes=" + likes
				+ ", comment=" + comment + ", postedOn=" + postedOn + "]";
	}
	

	
	

}
