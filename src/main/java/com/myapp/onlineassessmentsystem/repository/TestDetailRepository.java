package com.myapp.onlineassessmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.onlineassessmentsystem.model.TestDetail;

@Repository
public interface TestDetailRepository extends JpaRepository<TestDetail, String> {

}
