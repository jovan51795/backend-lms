package biz.global.model;

public class AdminResponse {
	private int status;
	private String token;
	private String message;
	
	public AdminResponse() {
	}
	
	public AdminResponse(int status, String token, String message) {
		this.status = status;
		this.token = token;
		this.message = message;
	}
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
