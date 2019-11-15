package com.myapp.onlineassessmentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.onlineassessmentsystem.model.AssessmentCorrectOption;

@Repository
public interface CorrectOptionsRepository extends JpaRepository<AssessmentCorrectOption, String> {
	
	List<AssessmentCorrectOption> findByAssessmentName(String assessmentName);

}


