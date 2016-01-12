package de.htwg.infe.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oracle.kv.AuthenticationRequiredException;
import oracle.kv.Direction;
import oracle.kv.DurabilityException;
import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.RequestTimeoutException;
import oracle.kv.avro.AvroCatalog;
import oracle.kv.avro.SpecificAvroBinding;

import org.apache.avro.Schema;

import de.htwg.infe.auth.Authentification;
import de.htwg.infe.blog.BlogEntry;
import de.htwg.infe.blog.User;
import de.htwg.infe.blog.UserLikesBlogEntry;

public class OracleDb {

	Authentification auth;
	final Schema.Parser parser = new Schema.Parser();
	private final KVStore store;
	private final AvroCatalog catalog;
	private final SpecificAvroBinding<User> userBinding;
	private final SpecificAvroBinding<BlogEntry> blogEntryBinding;
	private final SpecificAvroBinding<UserLikesBlogEntry> userLikesBlogEntryBinding;

	static final String USER_OBJECT_TYPE = "User";
	static final String BLOG_ENTRY_OBJECT_TYPE = "BlogEntry";
	static final String USER_LIKES_BLOG_ENTRY_OBJECT_TYPE = "UserLikesBlogEntry";

	private final static String basicIdZeros = "00000000";
	private String currentIdBlogEntry = "000000001";
	private String currentIdUser = "000000001";
	private String currentIdUserLikesBlogEntry = "000000001";

	public OracleDb(String host, String port, String storeName) {
		auth = new Authentification(host, port, storeName);
		store = auth.init();
		catalog = store.getAvroCatalog();
		userBinding = catalog.getSpecificBinding(User.class);
		blogEntryBinding = catalog.getSpecificBinding(BlogEntry.class);
		userLikesBlogEntryBinding = catalog
				.getSpecificBinding(UserLikesBlogEntry.class);
		prepareIncrementIds();

	}

	public void printRecords() {
		System.out.println();
		System.out.println("Anzahl User: "
				+ (Integer.valueOf(currentIdUser) - 1));
		System.out.println("Anzahl Blogentrys: "
				+ (Integer.valueOf(currentIdBlogEntry) - 1));
		System.out.println("Anzahl Likes: "
				+ (Integer.valueOf(currentIdUserLikesBlogEntry) - 1));

		System.out.println();
		System.out.println("User Einträge:");
		for (User u : getAllUsers()) {
			System.out.println(u.getName());
		}

		System.out.println();
		System.out.println("BlogEntry Einträge:");
		for (BlogEntry e : getAllBlogEntrys()) {
			System.out.println(e.getTitel());
		}

		System.out.println();
		System.out.println("UserLikeBlogEntry Einträge:");
		for (UserLikesBlogEntry l : getAllUserLikesBlogEntrys()) {
			System.out.println(l.getBlogEntry().getTitel() + " von "
					+ l.getUser().getName());
		}
		System.out.println();

	}

	public void prepareIncrementIds() {
		for (int i = 0; i < getAllUsers().size(); i++) {
			increaseCurrentIdUsers();
		}
		for (int i = 0; i < getAllBlogEntrys().size(); i++) {
			increaseCurrentIdBlogEntry();
		}
		for (int i = 0; i < getAllUserLikesBlogEntrys().size(); i++) {
			increasecurrentIdUserLikesBlogEntry();
		}

	}

	public void runExample() {

		/*
		 * User
		 */

		final User user = createUserObject("000000003", "Fab", "fab@test.de",
				"c:/1.jpg");

		/*
		 * Blog Entry
		 */

		List<CharSequence> a = new ArrayList<CharSequence>();
		a.add("Tag1");
		final BlogEntry entry = createBlogEntryObject("Neuer Titel", "test/1",
				"TEXTTEST", new Date(2015, 2, 2), a, user);

	}

	/**
	 * Uses the generated classes to create a MemberInfo instance that conforms
	 * to the MemberInfo schema.
	 */
	private User createUserObject(String id, String name, String email,
			String image) {

		final User user = new User();
		user.setId(id);
		user.setName(name);
		user.setMail(email);
		user.setBild(image);

		return user;
	}

	private BlogEntry createBlogEntryObject(String titel, String url,
			String text, Date date, List<CharSequence> tags, User user) {
		final BlogEntry entry = new BlogEntry();
		entry.setTitel(titel);
		entry.setUrl(url);
		entry.setText(text);
		entry.setDatum(date.getTime());
		entry.setTag(tags);
		entry.setAuthor(user);
		return entry;
	}

	private UserLikesBlogEntry createUserLikesBlogEntryObject(User user,
			BlogEntry entry) {
		final UserLikesBlogEntry likes = new UserLikesBlogEntry();
		likes.setBlogEntry(entry);
		likes.setUser(user);
		return likes;
	}

	public boolean isAuthentificated() {
		return auth.isConnected();
	}

	public Key createUser(final User user) throws DurabilityException,
			RequestTimeoutException, FaultException {

		final Key key = Key.createKey(Arrays.asList("mb", USER_OBJECT_TYPE));
		store.put(key, userBinding.toValue(user));

		return key;
	}

	public boolean deleteAllUsers() throws DurabilityException,
			RequestTimeoutException, FaultException {

		return true;
	}

	public boolean deleteUserById(String id) throws DurabilityException,
			RequestTimeoutException, FaultException {
		final Key userKey = Key.createKey(Arrays.asList("mb", USER_OBJECT_TYPE,
				id));
		return deleteUserByKey(userKey);
	}

	public boolean deleteUserByKey(Key userKey) throws DurabilityException,
			RequestTimeoutException, FaultException {
		return store.delete(userKey);
	}

	public Key createBlogEntry(BlogEntry entry) throws DurabilityException,
			RequestTimeoutException, FaultException {
		increaseCurrentIdBlogEntry();
		final Key key = Key.createKey(BLOG_ENTRY_OBJECT_TYPE,
				Arrays.asList("mb", this.currentIdBlogEntry));

		store.put(key, blogEntryBinding.toValue(entry));

		return key;
	}

	public boolean deleteBlogEntry(BlogEntry entry) {

		return true;
	}

	public boolean likeBlogEntry(BlogEntry entry) {

		return true;
	}

	public boolean changeUserEmail(String email) {

		return true;
	}

	public boolean changeBlogTitel(String titel) {

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

	public List<User> getAllUsers() {
		// final Key userTypeKey = Key.createKey(USER_OBJECT_TYPE);
		final Iterator<KeyValueVersion> iter = store.storeIterator(
				Direction.UNORDERED, 0 /* batchSize */, /* userTypeKey */null,
				null /* subRange */, null /* depth */);

		// final List<String> majorPath = userTypeKey.getMajorPath();
		// final String objectType = majorPath.get(0);

		List<User> users = new ArrayList<User>();
		/*
		 * Print each Key/Value pair returned by the iterator.
		 */
		while (iter.hasNext()) {
			final KeyValueVersion keyValue = iter.next();
			try {
				// System.out.println("keyValue.getKey: " + keyValue.getKey() +
				// " objectType: " + objectType);
				final User user_1 = userBinding.toObject(keyValue.getValue());
				users.add(user_1);
				// System.out.println(user_1.getName());
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}

		}
		return users;

	}

	public List<BlogEntry> getAllBlogEntrys() {
		final Key blogEntryTypeKey = Key.createKey(BLOG_ENTRY_OBJECT_TYPE);
		final Iterator<KeyValueVersion> iter = store.storeIterator(
				Direction.UNORDERED, 0 /* batchSize */, /* blogEntryTypeKey */
				null, null /* subRange */, null /* depth */);

		final List<String> majorPath = blogEntryTypeKey.getMajorPath();
		final String objectType = majorPath.get(0);

		List<BlogEntry> entrys = new ArrayList<BlogEntry>();

		/*
		 * Print each Key/Value pair returned by the iterator.
		 */
		while (iter.hasNext()) {
			final KeyValueVersion keyValue = iter.next();
			try {
				final BlogEntry entry_1 = blogEntryBinding.toObject(keyValue
						.getValue());
				entrys.add(entry_1);
				// System.out.println(entry_1.getTitel());
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}

		}
		return entrys;

	}

	public List<UserLikesBlogEntry> getAllUserLikesBlogEntrys() {
		final Key userLikesBlogEntryTypeKey = Key
				.createKey(USER_LIKES_BLOG_ENTRY_OBJECT_TYPE);
		final Iterator<KeyValueVersion> iter = store.storeIterator(
				Direction.UNORDERED, 0 /* batchSize */, /* userLikesBlogEntryTypeKey */
				null, null /* subRange */, null /* depth */);

		final List<String> majorPath = userLikesBlogEntryTypeKey.getMajorPath();
		final String objectType = majorPath.get(0);

		List<UserLikesBlogEntry> likes = new ArrayList<UserLikesBlogEntry>();

		/*
		 * Print each Key/Value pair returned by the iterator.
		 */
		while (iter.hasNext()) {
			final KeyValueVersion keyValue = iter.next();
			try {
				final UserLikesBlogEntry like_1 = userLikesBlogEntryBinding
						.toObject(keyValue.getValue());
				likes.add(like_1);
				// System.out.println(like_1.getBlogEntry().getTitel() + " von "
				// + like_1.getUser().getName());
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}

		}
		return likes;

	}

	public String getCurrentIdBlogEntry() {
		return currentIdBlogEntry;
	}

	public void increaseCurrentIdBlogEntry() {
		this.currentIdBlogEntry = basicIdZeros
				+ String.valueOf(Integer.valueOf(this.currentIdBlogEntry) + 1);
	}

	public String getCurrentIdUser() {
		return currentIdUser;
	}

	public void increaseCurrentIdUsers() {
		this.currentIdUser = basicIdZeros
				+ String.valueOf(Integer.valueOf(this.currentIdUser) + 1);
	}

	public String getCurrentIdUserLikesBlogEntry() {
		return currentIdUserLikesBlogEntry;
	}

	public void increasecurrentIdUserLikesBlogEntry() {
		this.currentIdUserLikesBlogEntry = basicIdZeros
				+ String.valueOf(Integer
						.valueOf(this.currentIdUserLikesBlogEntry) + 1);
	}

	public String createId(int id) {
		return basicIdZeros + String.valueOf(id);
	}

	public void finish() {
		try {
			store.logout();
		} catch (AuthenticationRequiredException e) {
			System.out.println("INFO: Es war kein Nutzer angemelet");
		}

		store.close();
	}

}
