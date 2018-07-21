package com.example.demo.controller;


import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.*;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId){
	return studentService.retrieveCourses(studentId);	
	}
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId){
	return studentService.retrieveCourse(studentId, courseId);	
	}
	@GetMapping("/students/{studentId}")
	public Student retrieveDetailsForStudent(@PathVariable String studentId){
		return studentService.retriveStudent(studentId);	
		}
	@GetMapping("/students")
	public List<Student> retrieveDetailsForStudents(){
		return studentService.retrieveStudents();	
		}
	@RequestMapping(value="/students",method=RequestMethod.POST,consumes=APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerStudent(
			 @RequestBody Student newStudent) {

		return new ResponseEntity<Object>(studentService.addStudent(newStudent),HttpStatus.Ok);

		
	}
	@RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	void deleteStudent(@PathVariable String studentId
			 ) {

		boolean deleted= studentService.deleteStudent(studentId);
	
	}
	@RequestMapping(value="/students",method=RequestMethod.PUT,consumes=APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateStudent(
			 @RequestBody Student updateStudent) {
		// this service can change only name of the student
		//Student student = studentService.updateStudent(updateStudent);
		return new ResponseEntity<Object>(studentService.updateStudent(updateStudent),HttpStatus.Ok);
	}
	
}
