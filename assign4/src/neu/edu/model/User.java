package neu.edu.model;

public class User {

	private String name;
	private boolean isActive;
	private String sessionIDVariable;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getSessionId() {
		return sessionIDVariable;
	}
	
	public void setSessionId(String sessionId1) {
		this.sessionIDVariable = sessionId1;
	}

}
