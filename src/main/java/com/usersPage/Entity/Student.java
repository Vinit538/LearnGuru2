package com.usersPage.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	private String userId;
	private String studentName;
	private String studentGender;
	private String studentDob;
	private String studentAddress;
	private String studentEmail;
	private long studentPhone;
	private String studentEducation;
	private String studentBranch;
	private List<String> EnrolledCourse;
	private List<String> likedCourse;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String userId, String studentName, String studentGender, String studentDob, String studentAddress,
			String studentEmail, long studentPhone, String studentEducation, String studentBranch,
			List<String> enrolledCourse, List<String> likedCourse) {
		super();
		this.userId = userId;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentDob = studentDob;
		this.studentAddress = studentAddress;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentEducation = studentEducation;
		this.studentBranch = studentBranch;
		EnrolledCourse = enrolledCourse;
		this.likedCourse = likedCourse;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentEducation() {
		return studentEducation;
	}

	public void setStudentEducation(String studentEducation) {
		this.studentEducation = studentEducation;
	}

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}

	public List<String> getEnrolledCourse() {
		return EnrolledCourse;
	}

	public void setEnrolledCourse(List<String> enrolledCourse) {
		EnrolledCourse = enrolledCourse;
	}

	public List<String> getLikedCourse() {
		return likedCourse;
	}

	public void setLikedCourse(List<String> likedCourse) {
		this.likedCourse = likedCourse;
	}

	@Override
	public String toString() {
		return "Student [userId=" + userId + ", studentName=" + studentName + ", studentGender=" + studentGender
				+ ", studentDob=" + studentDob + ", studentAddress=" + studentAddress + ", studentEmail=" + studentEmail
				+ ", studentPhone=" + studentPhone + ", studentEducation=" + studentEducation + ", studentBranch="
				+ studentBranch + ", EnrolledCourse=" + EnrolledCourse + ", likedCourse=" + likedCourse + "]";
	}
	
}
