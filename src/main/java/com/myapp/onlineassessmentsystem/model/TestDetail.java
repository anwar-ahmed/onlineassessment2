package com.myapp.onlineassessmentsystem.model;


import javax.persistence.*;


@Entity
@Table(name="TEST_DETAIL")
public class TestDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	private String testdate;
	private String assessment;
    private int testmark;
    private String email;
    private String totalmark;
    private String result;
    
    public TestDetail() {}
    
      
	public TestDetail( String testdate, String assessment, int testmark, String email, String totalmark,String result) {

		this.testdate = testdate;
		this.assessment = assessment;
		this.testmark = testmark;
		this.email = email;
		this.totalmark = totalmark;
		this.result = result;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public int getTestmark() {
		return testmark;
	}
	public void setTestmark(int value) {
		this.testmark = value;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalmark() {
		return totalmark;
	}
	public void setTotalmark(String string) {
		this.totalmark = string;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
    
}
