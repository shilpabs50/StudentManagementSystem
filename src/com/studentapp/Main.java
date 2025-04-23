package com.studentapp;

public class Main {

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
		
		Student s1;
		s1=new Student("Stephen", 22, "S-178");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
//		s1.enrollCourse("DevOps");
		
//    	System.out.println(s1);
		s1.printStudentInfo();
		
		Student s2 = new Student("Mala",20,"S-180");
		s2.enrollCourse("DevOps");
		s2.enrollCourse("DSA");
//		System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("Uday",23,"S-182");
		s3.enrollCourse("DSA");
		s3.enrollCourse("Java");
//		System.out.println(s3);
		s3.printStudentInfo();
		

	}

}
