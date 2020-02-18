# How to import, build and run Application using Eclipse?
Step1: Clone the project from github
		git clone https://github.com/Harish-hr/person-crud-api.git
		
Step2: Import cloned project in to Eclipse as maven project

Step3: Refresh project to get Maven dependencies
		Right click on the imported project 
		Go to option "Maven"-> "Update Project"
		Check option "Force Update of Snapshots/Release"
		
Step4: Building project
		Right click on the imported project 
		Go to option "Run As" -> select "Maven Build"
		
Step5: How to Run? 
		Go to "PersonCrudApiApplication.java" file 
		Right click select "Run as"-> "Java Application"
		Now server will start 
		
Step6: Open the below link in browser (google chrome) to perform HTTP actions
		http://localhost:8080/swagger-ui.html#		
		
You can now perform HTTP action like POST, GET, PUT, DELETE. I have secured REST API's using spring boot web security. Here are the authentication details.

User Name: admin
Password: password


# How to import, build and run Application using IntelliJ?
Step1: Clone project 
	git clone https://github.com/Harish-hr/person-crud-api.git
	
Step2: Import Project as Maven
Go to File->New->"Project from Existing sources.." and select the cloned project.

Step3: Project refresh to get Maven dependencies
	Right click on the imported project 
	Go to option "Maven"-> "Reimport"
	
Step4: Building project
Go to “Build tab” in IntelliJ IDE and select "Build Project" option.

Step5: How to Run? 
Go to "PersonCrudApiApplication.java" file 
	Right click select "Run PersonCrudApiApplication...main()”
	Now server will start 
	
Step6: Open the below link in browser (google chrome) to perform HTTP actios
http://localhost:8080/swagger-ui.html#

You can now perform HTTP action like POST, GET, PUT, DELETE operations. REST API's are secured using spring boot web security. Here are the authentication details.
User Name: admin
Password: password
		

