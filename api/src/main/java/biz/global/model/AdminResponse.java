package biz.global.model;

public class AdminResponse {
	private int status;
	private String token;
	private String message;
	private Object object;
	
	public AdminResponse() {
	}
	
	public AdminResponse(int status, String token, String message) {
		this.status = status;
		this.token = token;
		this.message = message;
	}
	
	public AdminResponse(int status, String token, String message, Object object) {
		this.status = status;
		this.token = token;
		this.message = message;
		this.object = object;
	}
	

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
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
