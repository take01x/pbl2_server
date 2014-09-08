package jp.kobe_u.cspiral.alpaca.model;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="presenters")
public class Presenters {

	private Set<String> list;

	public Presenters() {
		list = new TreeSet<String>();
	}

	@XmlElement(name="presenter")
	public String[] getLists() {
		return list.toArray(new String[list.size()]);
	}

	public void add(String presenter) {
		list.add(presenter);
	}
}
