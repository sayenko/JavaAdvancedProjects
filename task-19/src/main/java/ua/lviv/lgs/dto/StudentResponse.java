package ua.lviv.lgs.dto;

public class StudentResponse {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String photoName;
	private String photoUri;
	
	public StudentResponse() {}

	public StudentResponse(String firstName, String lastName, Integer age, String photoName, String photoUri) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.photoName = photoName;
		this.photoUri = photoUri;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}	
	
}
