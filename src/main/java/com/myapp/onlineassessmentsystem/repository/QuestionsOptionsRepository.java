package com.myapp.onlineassessmentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.myapp.onlineassessmentsystem.model.QuestionsOptions;

@Repository
public interface QuestionsOptionsRepository extends JpaRepository<QuestionsOptions, String> {
	
	List<QuestionsOptions> findByAssessmentName(String assessmentName);

}



