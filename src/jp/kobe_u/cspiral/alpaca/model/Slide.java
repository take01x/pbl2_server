package jp.kobe_u.cspiral.alpaca.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="slide")
public class Slide {
	private String currentSlideURL;

	// default constructor for jaxb
	public Slide() {
		this("");
	}
	
	public Slide(String currentSlideURL) {
		this.setCurrentSlideURL(currentSlideURL);
	}

	@XmlElement(name="url")
	public String getCurrentSlideURL() {
		return currentSlideURL;
	}

	public void setCurrentSlideURL(String currentSlideURL) {
		this.currentSlideURL = currentSlideURL;
	}
}
