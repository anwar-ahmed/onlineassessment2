package com.myapp.onlineassessmentsystem.controller;


import javax.servlet.http.HttpServletRequest;

import com.myapp.onlineassessmentsystem.model.*;
import com.myapp.onlineassessmentsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

@Controller  
public class OnlineAssessmentController {  
	
	public final static String  userEmail1 = "USER_EMAIL";
	public final static String  springAssessment="SpringAssessment";
	public final static String  hibernateAssessment="HibernateAssessment";
	
	@Autowired
	private UserRepository userReposiotry;
	
	@Autowired
	private  CorrectOptionsRepository correctOptionsRepository;
	
	@Autowired
	private QuestionsOptionsRepository questionOptionsRepository;
	
	@Autowired
	private TestDetailRepository testDetailRepository;
	
    @RequestMapping(value= "/index.html", method= RequestMethod.GET)
    public String getOnlineAssessmentHome(Model model) {
    	model.addAttribute("user", new User());
        return "OnlineAssessmentHome";
    }
    
    @RequestMapping(value= "/", method= RequestMethod.GET)
    public String getOnlineAssessmentHome2(Model model) {
    	model.addAttribute("user", new User());
        return "OnlineAssessmentHome";
    }
    
    @RequestMapping(value= "/SelectTests", method= RequestMethod.GET)
    public String getSelectTests() {
        return "SelectTests";
    }
    

    
    @RequestMapping(value= "/login/do", method= RequestMethod.POST)
    public String postLogin(@ModelAttribute User user,HttpServletRequest request ) {
    	
    	
    	Optional<User> val = userReposiotry.findById(user.getEmail());
    	
    	
    	if(val.isPresent()) {   		
    		
    		User dbUserValue =  val.get();
    		
    		if(user.getPassword().equals(dbUserValue.getPassword())) {  
    			
    			request.getSession().setAttribute(userEmail1, user.getEmail());
    			    			
    			if(dbUserValue.getUsertype().contentEquals("admin")) {  				
    				return "SelectReports" ;
    			} else {
    				return "SelectTests";
    			}
    			
    		} else {

    			return "PasswordError";
    		}
    		
    	} else {  	
        return "InvalidUser";
    	}
    }
	
    
    @RequestMapping(value= "/register.html", method= RequestMethod.GET)
    public String getRegistration(Model model) {
    	
    	model.addAttribute("user", new User());
        return "Registration";
    }
    
    @RequestMapping(value= "/registration/do", method= RequestMethod.POST)
    public String postRegistration(@ModelAttribute User user ) {
    	
    	user.setUsertype("candidate");
    	userReposiotry.save(user); 

        return "RegistrationConfirmation";
    }
    
    @RequestMapping(value= "/springAssessment.html", method= RequestMethod.GET)
    public String getSpringAssessment(Model model) {
    	
    	
    	List<QuestionsOptions> questionsOptions = questionOptionsRepository.findByAssessmentName(springAssessment);
    	
    	 Map<String,String> questions = new HashMap<>();
    	 questions.put("Questions1","");
    	 questions.put("Questions2","");
    	 questions.put("Questions3","");
    	 questions.put("Questions4","");
    	 questions.put("Questions5","");
    	
    	AssessmentAnswersForm assessmentAnswersForm = new AssessmentAnswersForm();
    	Map<String, String> assessmentAnswers = new HashMap<>();
    	
    	assessmentAnswers.putAll(questions);
    	assessmentAnswersForm.setAssessmentAnswers(assessmentAnswers);
    	model.addAttribute("assessmentAnswersForm",assessmentAnswersForm);
    	model.addAttribute("questionsOptions",questionsOptions);
    	
        return "SpringAssessment";
    }
    
    @RequestMapping(value= "/evaluate/spring/test", method= RequestMethod.POST)
    public String postSpringAssessment(@ModelAttribute AssessmentAnswersForm assessmentAnswersForm,HttpServletRequest request) {
    	   	
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");  
        String strDate = formatter.format(date);  
        
        String userEmail =  (String) request.getSession().getAttribute(userEmail1);
        
        
        int[] score = { 0 };
         	
    	String result = "FAIL" ;
    	
    	
    	List<AssessmentCorrectOption> getCorrectOption = correctOptionsRepository.findByAssessmentName(springAssessment);
    	
    	getCorrectOption.forEach(item -> {
    		if(assessmentAnswersForm.getAssessmentAnswers().get(item.getQuestion()).equals(item.getCorrectOption())) {
    			score[0] = score[0] + 10 ;
    		}
    	});
    	
    	if(score[0] >= 30) {
    		result="PASS";
    	}
    	
    	TestDetail testDetail = new TestDetail();
    	
    	testDetail.setTestdate(strDate);
    	testDetail.setAssessment("Spring-L1");
    	testDetail.setTotalmark("50");
    	testDetail.setTestmark(score[0]);
    	testDetail.setEmail(userEmail);
    	testDetail.setResult(result);
    	
    	testDetailRepository.save(testDetail);
    	
    	if(result.contentEquals("PASS")) {
    		return "TestSuccess";
    	} else {
        return "TestFailure";
    	}
    }
    
    @RequestMapping(value= "/hibernateAssessment.html", method= RequestMethod.GET)
    public String getHibernateAssessment(Model model) {
    	
    	
    	List<QuestionsOptions> questionsOptions = questionOptionsRepository.findByAssessmentName(hibernateAssessment);
    	
    	 Map<String,String> questions = new HashMap<>();
    	 questions.put("Questions1","");
    	 questions.put("Questions2","");
    	 questions.put("Questions3","");
    	 questions.put("Questions4","");
    	 questions.put("Questions5","");
    	
    	AssessmentAnswersForm assessmentAnswersForm = new AssessmentAnswersForm();
    	Map<String, String> assessmentAnswers = new HashMap<>();
    	
    	assessmentAnswers.putAll(questions);
    	assessmentAnswersForm.setAssessmentAnswers(assessmentAnswers);
    	model.addAttribute("assessmentAnswersForm",assessmentAnswersForm);
    	model.addAttribute("questionsOptions",questionsOptions);
    	
        return "HibernateAssessment";
    }
    
    @RequestMapping(value= "/evaluate/hibernate/test", method= RequestMethod.POST)
    public String postHibernateAssessment(@ModelAttribute AssessmentAnswersForm assessmentAnswersForm,HttpServletRequest request) {
    	    	
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");  
        String strDate = formatter.format(date);  
    	
        String userEmail =  (String) request.getSession().getAttribute(userEmail1);
     	
        int[] score = { 0 };
        
    	String result = "FAIL" ;
    	
    	
    	List<AssessmentCorrectOption> getCorrectOption = correctOptionsRepository.findByAssessmentName(hibernateAssessment);
    	
    	getCorrectOption.forEach(item -> {
    		if(assessmentAnswersForm.getAssessmentAnswers().get(item.getQuestion()).equals(item.getCorrectOption())) {
    			score[0] = score[0] + 10 ;
    		}
    	});
    	
    	if(score[0] >= 30) {
    		result="PASS";
    	}
    	
    	TestDetail testDetail = new TestDetail();
    	
    	testDetail.setTestdate(strDate);
    	testDetail.setAssessment("Hibernate-L1");
    	testDetail.setTotalmark("50");
    	testDetail.setTestmark(score[0]);
    	testDetail.setEmail(userEmail);
    	testDetail.setResult(result);
    	
    	testDetailRepository.save(testDetail);
    	
    	if(result.contentEquals("PASS")) {
    		return "TestSuccess";
    	} else {
        return "TestFailure";
    	}
    }
    	
    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public String getAllUserDetails(Model model) {
   	
    	List<User> listUsers = userReposiotry.findAll().stream().sorted(Comparator.comparing(User::getFirstname)).collect(Collectors.toList());
 	
        model.addAttribute("users", listUsers);
        return "AllUserDetails";
    }
    
    @RequestMapping(path = "/tests/all", method = RequestMethod.GET)
    public String getAllTestDetails(Model model) {
   	
    	List<TestDetail> listTestDetails = testDetailRepository.findAll().stream().sorted(Comparator.comparing(TestDetail::getTestdate)).collect(Collectors.toList());
 	
        model.addAttribute("testdetails", listTestDetails);
        return "AllTestDetails";
    }
    
	@RequestMapping(path = "/logout",method = RequestMethod.GET)
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index.html";
	}
}  