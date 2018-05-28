package neu.edu.model;

public class UserSession {
	private String id;
	private String name;
	private String role;
        private Boolean success;
        
	public String getUserId() {
		return id;
	}
	public void setUserId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return name;
	}
	public void setUserName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return role;
	}
	public void setUserType(String role) {
		this.role = role;
	}
        public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
