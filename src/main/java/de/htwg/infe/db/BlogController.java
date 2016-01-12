package de.htwg.infe.db;


public class BlogController {

	final OracleDb db;

	public BlogController(OracleDb _db) {
		this.db = _db;
	}

	public void runExample() {
		// db.runExample();
		System.out.println("Users:");

		db.printRecords();
		db.finish();
		/*
		 * UserPojo alice = new UserPojo(1, "Alice", "", "alice@example.org");
		 * UserPojo bob = new UserPojo(2, "Bob", "", "bob@example.org");
		 * UserPojo charlie = new UserPojo(3, "Charlie", "",
		 * "http://example.org/pics/c.jpg");
		 * 
		 * BlogEntryPojo e1 = new BlogEntryPojo(new Date(2015,11,11),
		 * "Lore ...", "http://example.org/be/1", "BE-1", new String[]{});
		 * BlogEntryPojo e2 = new BlogEntryPojo(new Date(2015,11,12),
		 * "Ipsum ...", "http://example.org/be/2", "BE-2", new
		 * String[]{"NoSQL"}); BlogEntryPojo e3 = new BlogEntryPojo(new
		 * Date(2015,11,12), "Dolor ...", "http://example.org/be/3", "BE-3", new
		 * String[]{"DBS","API","DML"});
		 */

	}

}
