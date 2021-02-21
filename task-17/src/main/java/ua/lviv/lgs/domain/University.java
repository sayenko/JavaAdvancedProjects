package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "level_of_accreditation")
	private Integer levelOfAccreditation;
	
	@Column(name = "number_of_institutes")
	private Integer numberOfInstitutes;
	
	@Column(name = "amount_of_students")
	private Integer amountOfStudents;
	
	@Column(name = "university_address")
	private String universityAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevelOfAccreditation() {
		return levelOfAccreditation;
	}

	public void setLevelOfAccreditation(Integer levelOfAccreditation) {
		this.levelOfAccreditation = levelOfAccreditation;
	}

	public Integer getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(Integer numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public Integer getAmountOfStudents() {
		return amountOfStudents;
	}

	public void setAmountOfStudents(Integer amountOfStudents) {
		this.amountOfStudents = amountOfStudents;
	}

	public String getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}

	@Override
	public String toString() {
		return "Univercity [id=" + id + ", name=" + name + ", levelOfAccreditation=" + levelOfAccreditation
				+ ", numberOfInstitutes=" + numberOfInstitutes + ", amountOfStudents=" + amountOfStudents
				+ ", universityAddress=" + universityAddress + "]";
	}	
	
}
