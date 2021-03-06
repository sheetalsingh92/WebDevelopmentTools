package neu.edu;
// Generated Dec 13, 2016 8:59:55 PM by Hibernate Tools 5.1.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer userId;
	private String username;
	private String password;
	private String name;
	private String dob;
	private String gender;
	private String emailId;
	private String type;
	private Admin admin;
	private Owner owner;
	private Set<Replies> replieses = new HashSet<Replies>(0);
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Customer customer;
	private Set<Restaurant> restaurants = new HashSet<Restaurant>(0);

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String password, String name, String dob, String gender, String emailId, String type,
			Admin admin, Owner owner, Set<Replies> replieses, Set<Comments> commentses, Customer customer,
			Set<Restaurant> restaurants) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.emailId = emailId;
		this.type = type;
		this.admin = admin;
		this.owner = owner;
		this.replieses = replieses;
		this.commentses = commentses;
		this.customer = customer;
		this.restaurants = restaurants;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Set<Replies> getReplieses() {
		return this.replieses;
	}

	public void setReplieses(Set<Replies> replieses) {
		this.replieses = replieses;
	}

	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Restaurant> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
