package com.usersPage.Entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Course {
	@Id
	private String courseId;
	private String courseTitle;
	private String courseSubTitle;
	private String courseDescription;
	private String courseSkills;
	private String trainerId;
	@Lob
	@Column(name = "course_image", columnDefinition = "LONGBLOB")
	private byte[]  courseImage;
    private int noOfLessons; // This should represent the number of lessons
	private int courseLikes;
	private int courseEnroll;
	private List<String> LikedId;
	private List<String> EnrolledId;
	private double courseRating;
	
    public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId, String courseTitle, String courseSubTitle, String courseDescription,
			String courseSkills, String trainerId, byte[] courseImage, int noOfLessons, int courseLikes,
			int courseEnroll, List<String> likedId, List<String> enrolledId, double courseRating) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseSubTitle = courseSubTitle;
		this.courseDescription = courseDescription;
		this.courseSkills = courseSkills;
		this.trainerId = trainerId;
		this.courseImage = courseImage;
		this.noOfLessons = noOfLessons;
		this.courseLikes = courseLikes;
		this.courseEnroll = courseEnroll;
		LikedId = likedId;
		EnrolledId = enrolledId;
		this.courseRating = courseRating;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseSubTitle() {
		return courseSubTitle;
	}

	public void setCourseSubTitle(String courseSubTitle) {
		this.courseSubTitle = courseSubTitle;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseSkills() {
		return courseSkills;
	}

	public void setCourseSkills(String courseSkills) {
		this.courseSkills = courseSkills;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public byte[] getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(byte[] courseImage) {
		this.courseImage = courseImage;
	}

	public int getNoOfLessons() {
		return noOfLessons;
	}

	public void setNoOfLessons(int noOfLessons) {
		this.noOfLessons = noOfLessons;
	}

	public int getCourseLikes() {
		return courseLikes;
	}

	public void setCourseLikes(int courseLikes) {
		this.courseLikes = courseLikes;
	}

	public int getCourseEnroll() {
		return courseEnroll;
	}

	public void setCourseEnroll(int courseEnroll) {
		this.courseEnroll = courseEnroll;
	}

	public List<String> getLikedId() {
		return LikedId;
	}

	public void setLikedId(List<String> likedId) {
		LikedId = likedId;
	}

	public List<String> getEnrolledId() {
		return EnrolledId;
	}

	public void setEnrolledId(List<String> enrolledId) {
		EnrolledId = enrolledId;
	}

	public double getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(double courseRating) {
		this.courseRating = courseRating;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseSubTitle=" + courseSubTitle
				+ ", courseDescription=" + courseDescription + ", courseSkills=" + courseSkills + ", trainerId="
				+ trainerId + ", courseImage=" + Arrays.toString(courseImage) + ", noOfLessons=" + noOfLessons
				+ ", courseLikes=" + courseLikes + ", courseEnroll=" + courseEnroll + ", LikedId=" + LikedId
				+ ", EnrolledId=" + EnrolledId + ", courseRating=" + courseRating + "]";
	}
}
