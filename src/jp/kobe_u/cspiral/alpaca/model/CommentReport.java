package jp.kobe_u.cspiral.alpaca.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentReport {
	private List<Comment> comments;

	// default constructor for jaxb
	public CommentReport() {
		this("");
	}
	public CommentReport(String presenter) {
		comments = new ArrayList<Comment>();
	}

	@XmlElement(name="comment")
	public Comment[] getComments() {
		return comments.toArray(new Comment[comments.size()]);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
