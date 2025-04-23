package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	
	private static List<Student> studentsList; 
	
	public static void main(String[] args) {
		
		System.out.println("***************Student Management System*****************");
		System.out.println("*************Welcome********************");
		
		// here s1 is a reference and not object, reference stores the unique identification/hashcode of the object created
		   // in the heap memory
       // when the new object is created, 
		//student class will be loaded in memory,
		//instance variable will be created in heap, 
		//constructor will be called		
		// new object is always created in the heap memory
		// stream can be used only on collections
		// Local variables are never initialized implicitly, it has to be done explicitly
		
		//to read the input from the terminal
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Student name: ");
		String name = scanner.next();
		System.out.println("You have entered the name "+name);
		
		//to read integer values from the console nextInt() method
		System.out.println("Enter the student Age: ");
		int age = scanner.nextInt();
		System.out.println("You entered the Age: "+age);
		
		
	}
	
	
	
	private static void sortByName() {
		
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentsList,studentNameComparator);
		System.out.println(studentsList);
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
