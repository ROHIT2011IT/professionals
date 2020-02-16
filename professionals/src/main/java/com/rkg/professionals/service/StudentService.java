package com.rkg.professionals.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkg.professionals.dto.request.StudentRequest;
import com.rkg.professionals.entities.StudentEntity;
import com.rkg.professionals.entities.SubjectEntity;
import com.rkg.professionals.entities.SkillEntity;
import com.rkg.professionals.repository.StudentRepository;
import com.rkg.professionals.repository.SubjectRepository;
import com.rkg.professionals.repository.SkillRepository;

@Service
public class StudentService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SkillRepository subSkillRepository;	

	public void addStudent(StudentRequest student) {
		StudentEntity studentEntity = StudentEntity.builder().firstName(student.getFirstName()).lastName(student.getLastName())
				.contactNumber(student.getContactNumber()).emailId(student.getEmailId()).gender(student.getGender()).build();
		studentRepository.save(studentEntity);
		System.out.println("hello");
	}
	
	public void addSkill(String skill, Long studentId) {
		SkillEntity  subSkill = subSkillRepository.findBySkill(skill);
		Optional<StudentEntity> student = studentRepository.findById(studentId);
		StudentEntity stud = student.get();
		System.out.println("size: "+stud.getSkillOpted().size());
		List<SkillEntity> studentSkills = stud.getSkillOpted();
		studentSkills.add(subSkill);
		stud.setSkillOpted(studentSkills);
		studentRepository.save(stud);
	}
	
}
