package de.htwg.infe.db;

import java.sql.Date;

import de.htwg.infe.blog.BlogEntry;
import de.htwg.infe.blog.User;

public class BlogController {

	
	final OracleDb db;
	
	public BlogController(OracleDb _db) {
		this.db = _db;
	}
	
	
	public void runExample() {
		User alice = new User(1, "Alice", "", "alice@example.org");
		User bob = new User(2, "Bob", "", "bob@example.org");
		User charlie = new User(3, "Charlie", "", "http://example.org/pics/c.jpg");
		
		BlogEntry e1 = new BlogEntry(new Date(2015,11,11), "Lore ...", "http://example.org/be/1", "BE-1", new String[]{});
		BlogEntry e2 = new BlogEntry(new Date(2015,11,12), "Ipsum ...", "http://example.org/be/2", "BE-2", new String[]{"NoSQL"});
		BlogEntry e3 = new BlogEntry(new Date(2015,11,12), "Dolor ...", "http://example.org/be/3", "BE-3", new String[]{"DBS","API","DML"});
		
	}
	
	
	public boolean createUser(User user) {
		
		return true;
	}
	
	public boolean deleteUser(User user) {
		return true;
	}
	
	public boolean createBlogEntry(BlogEntry entry) {
		
		return true;
	}
	
	public boolean deleteBlogEntry(BlogEntry entry) {
		
		return true;
	}
	
	public boolean likeBlogEntry(BlogEntry entry) {
		
		return true;
	}
	
	public boolean changeUserEmail() {
		
		return true;
	}
	
	public boolean changeBlogTitel() {
		
		return true;
	}
	
	public BlogEntry[] getBlogEntrysFromUser(User user) {
		
		return null;
	}
	
	public int getLikesOfBlogEntry(BlogEntry entry) {
		
		return 0;
	}
	
	public BlogEntry getBlogEntryWithMostLikes() {
		
		return null;
	}
}
