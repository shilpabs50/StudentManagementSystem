package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	
	private static List<Student> studentsList; 
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		System.out.println("***************Student Management System*****************");
		
		
		studentsList = new ArrayList<Student>();
		
	while(true) {
		
		System.out.println("*************Welcome********************");
		
		System.out.println("Select an Option...........");
		System.out.println("1. Register a Student");
		System.out.println("2. Find the Student with the Student Id");
		System.out.println("3. List all Student Information");
		System.out.println("4. List Student Information in the sorted order");
		System.out.println("5. Exit");

       scanner = new Scanner(System.in);
       int option = scanner.nextInt();
       
       switch(option) {
       
       case 1: enrollStudent(scanner);
       		   break;
       case 2 : findStudentById(scanner);
               break;
       case 3 : printAllStudentData();
                break;
       case 4: sortByName();
               break;
       case 5: Exit();
               break;
       
       default: System.out.println("Invalid option selected!............Enter between 1 to 5");
       
       }
       
      }

	}
	
	
	
	private static void Exit() {
		System.out.println("Thanks and Bye for now!!!!!");
		System.exit(0);
		
	}



	private static void printAllStudentData() {
		
		if(studentsList.size()>0)
		{
	
		System.out.println("-----------------------PRINTING ALL THE STUDENT INFO-----------------------");
		for(Student student : studentsList)
		{
			student.printStudentInfo();
		}
		
		System.out.println("-----------------------**********************************-----------------------");
	  }
		
		else {
			System.err.println("Student list is Empty!!! No Student record found");
		}
   }



	private static void findStudentById(Scanner scanner2) {
		
		System.out.println("Enter the student Id to search");
		String studentSearchId = scanner2.next();
		
		Student studentFound = null;
	
		try {
		studentFound = studentsList.stream().filter(student ->student.getStudentId().equalsIgnoreCase(studentSearchId))
		.findFirst().orElseThrow(() -> new RuntimeException("Data not found!!!"));
		 
		studentFound.printStudentInfo();
		 
		}catch(RuntimeException e) {
			
			System.out.println("Student with the id "+studentSearchId+" is not found!!!!");
			
		}
	
		
	
	}



	private static void enrollStudent(Scanner scanner2) {
		
		System.out.println("Enter the Student name");
		String studentName = scanner2.next();
		
		System.out.println("Enter the Student Age");
		int studentage = scanner2.nextInt();
		
		System.out.println("Enter the Student Id");
		String studentId = scanner2.next();
		
		
		Student newStudent = new Student(studentName,studentage,studentId);
		studentsList.add(newStudent);
		System.out.println("Student is added to the LMS successfully");
		
		while(true) {
			System.out.println("Enter the course to be enrolled!!!, type Done to exit");
			String courseName = scanner2.next();
			
			if(courseName.equalsIgnoreCase("done")) {
				break; // exit the loop
			}
			
			newStudent.enrollCourse(courseName);
			
		}
		
	   // newStudent.printStudentInfo();
		
	}



	private static void sortByName() {
		
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
	    Collections.sort(studentsList,studentNameComparator);
		//System.out.println(studentsList);
		printAllStudentData();
		
	}



	public static Student findStudentById(String studentId) {
		
		Student result = null;
		try {
		result = studentsList
				.stream()
				.filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		
		}catch(RuntimeException e) {
			
			System.err.println("Student with the id "+studentId+" is not found");
		}
			
		return result;

	}

	

}
