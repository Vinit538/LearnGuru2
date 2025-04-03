package com.usersPage.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lessons {
	
	@Id
	private String lsnId;
	private String lsnTitle;
	private String lsnSubTitle;
	@Column(name = "lsnDescription", columnDefinition = "LONGBLOB")
	private String lsnDescription;
	@Column(name = "lsnContent", columnDefinition = "LONGBLOB")
	private String lsnContent;
	private String lsnContentUrl;
	private String trainerId;
	private String courseId;
	
	public Lessons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lessons(String lsnId, String lsnTitle, String lsnSubTitle, String lsnDescription, String lsnContent,
			String lsnContentUrl, String trainerId, String courseId) {
		super();
		this.lsnId = lsnId;
		this.lsnTitle = lsnTitle;
		this.lsnSubTitle = lsnSubTitle;
		this.lsnDescription = lsnDescription;
		this.lsnContent = lsnContent;
		this.lsnContentUrl = lsnContentUrl;
		this.trainerId = trainerId;
		this.courseId = courseId;
	}

	public String getLsnId() {
		return lsnId;
	}

	public void setLsnId(String lsnId) {
		this.lsnId = lsnId;
	}

	public String getLsnTitle() {
		return lsnTitle;
	}

	public void setLsnTitle(String lsnTitle) {
		this.lsnTitle = lsnTitle;
	}

	public String getLsnSubTitle() {
		return lsnSubTitle;
	}

	public void setLsnSubTitle(String lsnSubTitle) {
		this.lsnSubTitle = lsnSubTitle;
	}

	public String getLsnDescription() {
		return lsnDescription;
	}

	public void setLsnDescription(String lsnDescription) {
		this.lsnDescription = lsnDescription;
	}

	public String getLsnContent() {
		return lsnContent;
	}

	public void setLsnContent(String lsnContent) {
		this.lsnContent = lsnContent;
	}

	public String getLsnContentUrl() {
		return lsnContentUrl;
	}

	public void setLsnContentUrl(String lsnContentUrl) {
		this.lsnContentUrl = lsnContentUrl;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Lessons [lsnId=" + lsnId + ", lsnTitle=" + lsnTitle + ", lsnSubTitle=" + lsnSubTitle
				+ ", lsnDescription=" + lsnDescription + ", lsnContent=" + lsnContent + ", lsnContentUrl="
				+ lsnContentUrl + ", trainerId=" + trainerId + ", courseId=" + courseId + "]";
	}
}
