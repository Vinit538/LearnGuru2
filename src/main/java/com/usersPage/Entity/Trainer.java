package com.usersPage.Entity;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.*;
@Entity
public class Trainer {

	@Id
	private String trainerId;
	private String trainerName;
	private String trainerGender;
	private String trainerDob;
	private String trainerAddress;
	private String trainerEmail;
	private long trainerPhone;
	private String trainerEducation;
	private String trainerBranch;
	 @ElementCollection
	    @CollectionTable(name = "trainer_course_mapping", joinColumns = @JoinColumn(name = "trainer_id"))
	    @MapKeyColumn(name = "course_name")
	    @Column(name = "course_description")
	    private Map<String, String> course;
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String trainerId, String trainerName, String trainerGender, String trainerDob, String trainerAddress,
			String trainerEmail, long trainerPhone, String trainerEducation, String trainerBranch,
			Map<String, String> course) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerGender = trainerGender;
		this.trainerDob = trainerDob;
		this.trainerAddress = trainerAddress;
		this.trainerEmail = trainerEmail;
		this.trainerPhone = trainerPhone;
		this.trainerEducation = trainerEducation;
		this.trainerBranch = trainerBranch;
		this.course = course;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerGender() {
		return trainerGender;
	}

	public void setTrainerGender(String trainerGender) {
		this.trainerGender = trainerGender;
	}

	public String getTrainerDob() {
		return trainerDob;
	}

	public void setTrainerDob(String trainerDob) {
		this.trainerDob = trainerDob;
	}

	public String getTrainerAddress() {
		return trainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public long getTrainerPhone() {
		return trainerPhone;
	}

	public void setTrainerPhone(long trainerPhone) {
		this.trainerPhone = trainerPhone;
	}

	public String getTrainerEducation() {
		return trainerEducation;
	}

	public void setTrainerEducation(String trainerEducation) {
		this.trainerEducation = trainerEducation;
	}

	public String getTrainerBranch() {
		return trainerBranch;
	}

	public void setTrainerBranch(String trainerBranch) {
		this.trainerBranch = trainerBranch;
	}

	public Map<String, String> getCourse() {
		return course;
	}

	public void setCourse(Map<String, String> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerGender=" + trainerGender
				+ ", trainerDob=" + trainerDob + ", trainerAddress=" + trainerAddress + ", trainerEmail=" + trainerEmail
				+ ", trainerPhone=" + trainerPhone + ", trainerEducation=" + trainerEducation + ", trainerBranch="
				+ trainerBranch + ", course=" + course + "]";
	}

	
}
