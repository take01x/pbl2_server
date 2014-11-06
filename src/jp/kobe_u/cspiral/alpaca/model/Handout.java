package jp.kobe_u.cspiral.alpaca.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Handout")
public class Handout {
	private String handoutHtml;

	// default constructor for jaxb
	public Handout() {
		this("");
	}
	
	public Handout(String handoutHtml) {
		this.setHandoutHtml(handoutHtml);
	}

	@XmlElement(name="html")
	public String getHandoutHtml() {
		return this.handoutHtml;
	}

	public void setHandoutHtml(String handoutHtml) {
		this.handoutHtml = handoutHtml;
	}
}
