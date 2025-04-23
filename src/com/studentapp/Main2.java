package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	
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
		
		
		studentsList = new ArrayList<Student>();
		
		Student s1;
		s1=new Student("Stephen", 22, "S-178");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");

		
		Student s2 = new Student("Mala",20,"S-180");
		s2.enrollCourse("DevOps");
		s2.enrollCourse("DSA");

		
		Student s3 = new Student("Uday",23,"S-182");
		s3.enrollCourse("DSA");
		s3.enrollCourse("Java");
		
		//adding the student objects to the arraylist
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);
			
		Student result =findStudentById("S-182");
		System.out.println("Result is: "+result);
		//sorting by name
		sortByName();
			

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
