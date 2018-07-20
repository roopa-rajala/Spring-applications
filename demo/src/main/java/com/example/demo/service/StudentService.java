package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
@Component
public class StudentService {
	private static List<Student> students = new ArrayList<>();

	static {
		//Initialize Data
		Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
				.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring",
						"Learn Spring MVC", "First Example", "Second Example"));
		Course course4 = new Course("Course4", "Maven",
				"Most popular maven course on internet!", Arrays.asList(
						"Pom.xml", "Build Life Cycle", "Parent POM",
						"Importing into Eclipse"));

		Student ranga = new Student("Student1", "Ranga Karanam",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		Student satish = new Student("Student2", "Satish T",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		students.add(ranga);
		students.add(satish);
	}

	public List<Course> retrieveCourses(String studentId) {
		// TODO Auto-generated method stub
		Student student=retriveStudent(studentId);
		if(student==null)
			return null;
		
		return student.getCourses();
	}

	public Student retriveStudent(String studentId) {
		// TODO Auto-generated method stub
		for(Student student:students){
			if(student.getId().equals(studentId)){
				return student;
			}
		}
		return null;
	}

	public Course retrieveCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		Student student=retriveStudent(studentId);
		if(student ==null){
			return null;
		}
		for(Course course:student.getCourses()){
			if(course.getId().equals(courseId)){
				return course;
			}
		}
		return null;
	}

	

	public List<Student> retrieveStudents() {
		// TODO Auto-generated method stub
		if(students!=null){
			return students;
		}
		
		
		return null;
	}

	public Student addStudent(Student newStudent) {
		// TODO Auto-generated method stub
		System.out.println("->"+newStudent.getId());
		students.add(newStudent);
		return newStudent;
	}

	public boolean deleteStudent(String studentId) {
		// TODO Auto-generated method stub
		Student student=retriveStudent(studentId);
		if(student==null){
			return false;
		}
		students.remove(student);
		return true;
		
	}

	public Student updateStudent(Student updateStudent) {
		// TODO Auto-generated method stub
		if(updateStudent==null){
			return null;
		}
		Student student=retriveStudent(updateStudent.getId());
		if(student==null){
			addStudent(updateStudent);
			return updateStudent;
		}
		student.setName(updateStudent.getName());
		return updateStudent;
	}
}
