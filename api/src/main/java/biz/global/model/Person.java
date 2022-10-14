package biz.global.model;



public class Person {
	
	private static final long serialVersionUID = 1L;

	protected String firstName;
	
	protected String middleName;
	
	protected String lastName;
	
	protected String username;
	
	protected String password;
	
	protected String type;
	
	protected Boolean active_deactive;

	
	public Person() {
		super();
	}

	public Person(String firstName, String middleName, String lastName, String username, String password, String type,
			Boolean active_deactive) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.active_deactive = active_deactive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}

	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	
	
}
