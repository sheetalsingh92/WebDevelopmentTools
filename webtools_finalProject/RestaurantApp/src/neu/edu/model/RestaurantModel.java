package neu.edu.model;

public class RestaurantModel {
	private String restaurantName;
	private String location;
	private int star_rating;
	private String type;
	private String approval_status;
	
	public RestaurantModel(){
		
	}
	public RestaurantModel(String restaurantName,String location,int star_rating, String type,String approval_status)
	{
		this.restaurantName=restaurantName;
		this.location =location;
		this.star_rating =star_rating;
		this.type = type;
		this.approval_status = approval_status;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	
	

}
