INSERT INTO 
	USER (email, password, firstname,lastname,usertype) 
VALUES
  	('roger@gmail.com','wipro@123','Roger','Kutcher','admin'),
  	('steve@gmail.com','wipro@123','Steve','Martin','admin'),
  	('apple@apple.com','wipro@123','Apple','Apple','candidate');

  	
INSERT INTO 
	TEST_DETAIL (testdate, assessment, testmark,email,totalmark,result) 
VALUES
  	('23-11-2019 11:30:30','Spring-L1',20,'apple@apple.com','50','FAIL'),
  	('22-11-2019 10:30:30','Hibernate-L1',40,'orange@orange','50','PASS'),
  	('24-11-2019 11:30:30','Spring-L1',20,'apple@apple.com','50','FAIL');

  	
INSERT INTO
	ASSESSMENT_CORRECT_OPTIONS (assessmentname,question,correctoption)
VALUES
	('SpringAssessment','Question1','J2EE App Development Framework'),
	('SpringAssessment','Question2','Inversion Of Control'),
	('SpringAssessment','Question3','Aspect Oriented Programming'),
	('SpringAssessment','Question4','Application Context'),
	('SpringAssessment','Question5','Dispatcher Servlet'),
	('HibernateAssessment','Question1','Object Relational Mapping'),
	('HibernateAssessment','Question2','uni-directional & bi-directional'),
	('HibernateAssessment','Question3','configuration file'),
	('HibernateAssessment','Question4','Hibernate Query Language'),
	('HibernateAssessment','Question5','isolation levels');
  	
	
INSERT INTO
	QUESTIONS_OPTIONS (assessmentname,questionid,questiontext,option1,option2,option3,option4)
VALUES
	('SpringAssessment','Question1','Question 1: What is spring?','J2EE App Server','J2EE App Development Framework','Configuration Management Tool','Build Tool'),
	('SpringAssessment','Question2','Question 2: What is the full form of IOC?','Inversion Of Control','Interjection of Control','Internal Object Control','In-built Object Control'),
	('SpringAssessment','Question3','Question 3: What is the full form of AOP?','Anticipation of Properties','Aspect Oriented Programming','Associated Object Programming','Anti Object Programming'),
	('SpringAssessment','Question4','Question 4: Which of the below is a spring container?','View Resolver','Application Context','Handler Mapping','Dispatcher Servlet'),
	('SpringAssessment','Question5','Question 5: Which is Springs front Controller Implementation?','Bean Factory','Class Path Application Context','Application Context','Dispatcher Servlet'),
	('HibernateAssessment','Question1','Question 1: What is the full form of ORM?','Object Random Memory','Object Relational Mismatch','Object Relational Mapping','Object Random Mapping'),
	('HibernateAssessment','Question2','Question 2: In Hibernate, based on directionality, what could be the mappings?','uni-directional & bi-directional','one-to-many & many-to-one','inheritance mapping','north & south mapping'),
	('HibernateAssessment','Question3','Question 3: In an Hibernate application, which file would have datasource details?','hibernate mapping file','configuration file','Model/Entity class','HibernateUtil class'),
	('HibernateAssessment','Question4','Question 4: What is the full form of HQL?','High-level Query Language','Hidden Query Language','Hibernate Query Language','Hibernate Quadratic Language'),
	('HibernateAssessment','Question5','Question 5: In an Hibernate application, concurrency can be controlled by setting?','concurrency level','one-to-one mapping','many-to-one bi-directional mapping','isolation levels');