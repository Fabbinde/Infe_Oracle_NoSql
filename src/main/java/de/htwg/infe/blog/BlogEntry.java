package de.htwg.infe.blog;

import java.sql.Date;

public class BlogEntry {

	public Date datum;
	public String text;
	public String url;
	public String Titel;
	public String[] tag;
	private int likes;

	public BlogEntry(Date datum, String text, String url, String titel,
			String[] tag) {
		this.datum = datum;
		this.text = text;
		this.url = url;
		Titel = titel;
		this.tag = tag;
		setLikes(0);
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
