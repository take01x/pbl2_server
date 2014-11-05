package jp.kobe_u.cspiral.alpaca.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="like")
public class Like {
	private Date date;
	private String likeCount;

	public Like() {
		this(new Date(0), "");
	}
	public Like(Date date) {
		this(date, "");
	}
	public Like(Date date, String likeCount) {
		this.date = date;
		this.likeCount = likeCount;
	}

	@XmlElement(name="date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDate() {
		return date;
	}

	@XmlElement(name="likeCount")
	public String getuser() {
		return likeCount;
	}
}
