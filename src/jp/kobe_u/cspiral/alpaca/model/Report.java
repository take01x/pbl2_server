package jp.kobe_u.cspiral.alpaca.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="report")
public class Report {
	private String presenter;
	private int totalLike;
	private List<Like> likes;
	private List<Comment> comments;

	// default constructor for jaxb
	public Report() {
		this("");
	}
	public Report(String presenter) {
		this.presenter = presenter;
		this.totalLike = 0;
		likes = new ArrayList<Like>();
		comments = new ArrayList<Comment>();
	}

	@XmlElement(name="presenter")
	public String getPresenter() {
		return presenter;
	}
	@XmlElement(name="total_like")
	public int getTotalLike() {
		return totalLike;
	}
	@XmlElement(name="like")
	public Like[] getLikes() {
		return likes.toArray(new Like[likes.size()]);
	}
	@XmlElement(name="comment")
	public Comment[] getComments() {
		return comments.toArray(new Comment[comments.size()]);
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void setTotalLike(int totalLike) {
		this.totalLike = totalLike;
	}



}
