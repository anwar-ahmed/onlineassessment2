package com.myapp.onlineassessmentsystem.model;


import java.util.HashMap;
import java.util.Map;

public class AssessmentAnswersForm {
	
	private Map<String,String> assessmentAnswers = new HashMap<>();
	


	public  Map<String,String> getAssessmentAnswers() {
		return assessmentAnswers;
	}

	public void setAssessmentAnswers(Map<String,String> assessmentAnswers) {
		this.assessmentAnswers = assessmentAnswers;
	}
	

}
