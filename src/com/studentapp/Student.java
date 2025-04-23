package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

//attributes which are created inside the class and are non-static they are called as instance variables
//variables which are created inside the class and are statid, then they are called class variables
// whenever they say attributes they are talking about instance variables
//instance variables are always private, unless for specific reasons it is made as public but its always private
//non primitive data types will always have default value as null, in this case name, studentId and courses are references for
	// their nonprimitive data types
// all instance variables should be initialized inside the constructor of the class	
	// super keyword always calls the parent class constructor, in this case it is Object class, the super class in java
	// purpose of this keyword is to differentiate between the local variable and the instance variables when they have same names
	// validation checks should be done for the instance variables
	// ArrayList is idempotent in nature, meaning it allows duplicate values to be added in the list

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public Student(String name, int age, String studentId) {
		super();
	if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {	
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<String>(); 		// Intialization of courses as it is also the instance variable
	}
}

	private boolean validateStudentId(String studentId) {
		
		String studentIdRegex = "S-[0-9]+$";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if(studentIdMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Enter the studenId in the format.....Eg.....S-123");
			return false;
		}
	}
	
	
	

	public void enrollCourse(String course) {
				
	if(validateCourse(course)) {
		if(!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student is enrolled to " + course + " successfully!!!");			
		}
		else {
			
			System.err.println("Student is already enrolled to the course "+course);
		}
	}
	
}
	
	
	

	public void printStudentInfo() {

		System.out.println("========= Student Information =========");
		System.out.println("Student Name: " + name);
		System.out.println("Student age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Student Enrolled for: " + courses);
        System.out.println("========================================");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	
	
	//Validation methods
	
	public boolean validateAge(int age) {
		
		if(age>=19 && age<=35) {
			
			return true;
		}
		else {
			System.err.println("Age value is invalid, age should be between 19yrs to 35yrs");
			return false;
		}
		
	}
	
	
	
	public boolean validateName(String name) {
		
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern =Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		
		if(nameMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid name !!! Please enter alphabets only");
			return false;
		}
	}
	
	
	public boolean validateCourse(String course) {
		
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;			
		}
		else {
			
			System.err.println("Invalid course name, please select the course from the list [Java,DSA,DevOps]");
			return false;
		}
		
	}
	
	
	
	

}
