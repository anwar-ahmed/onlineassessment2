package com.myapp.onlineassessmentsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ASSESSMENT_CORRECT_OPTIONS")

public class AssessmentCorrectOption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
	
	@Column(name="ASSESSMENTNAME")
	private String assessmentName;
	private String question;
	@Column(name="CORRECTOPTION")
    private String correctOption;
    
    public AssessmentCorrectOption() {}
    
	public AssessmentCorrectOption(String assessmentName, String question, String correctOption) {
		this.assessmentName = assessmentName;
		this.question = question;
		this.correctOption = correctOption;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	
	
	

}
