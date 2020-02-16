package com.rkg.professionals.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkg.professionals.commons.RestConstants;
import com.rkg.professionals.dto.request.StudentRequest;
import com.rkg.professionals.entities.StudentEntity;
import com.rkg.professionals.entities.constant.Gender;
import com.rkg.professionals.service.StudentService;

@RestController("userControllerV1")
@RequestMapping(RestConstants.VERSION_ONE + "/students")
public class UserController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public void addStudent(@RequestBody StudentRequest student) {
		studentService.addStudent(student);
	}
	
	@GetMapping
	public StudentRequest getStudent() {
		return StudentRequest.builder().firstName("Rohit").lastName("Garg").contactNumber("9898877665").emailId("aff").gender(Gender.MALE).build();
	}
	
	@PostMapping("/{studentId}/{skillName}")
	public void addSkill(@PathVariable("skillName") String skill, @PathVariable("studentId") Long studentId) {
		studentService.addSkill(skill, studentId);
	}
}
