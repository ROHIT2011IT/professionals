package com.rkg.professionals.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkg.professionals.entities.SkillEntity;
import com.rkg.professionals.entities.SubjectEntity;
import com.rkg.professionals.exception.SkillAlreadyExistException;
import com.rkg.professionals.exception.SubjectAlreadyExistException;
import com.rkg.professionals.exception.SubjectNotFoundException;
import com.rkg.professionals.repository.SkillRepository;
import com.rkg.professionals.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	private static final String SUBJECT_ALREADY_EXIST = "Subject %s alreday exist";
	private static final String SUBJECT_NOT_FOUND = "Subject %s not found";
	private static final String SKILL_ALREADY_EXIST = "Skill %s already exist with subject %s";
	
	public Long createSubject(String subjectRequest) {
		Optional<SubjectEntity> subjectEntity = subjectRepository.findBySubject(subjectRequest);
		subjectEntity.ifPresent(entity ->{
			throw new SubjectAlreadyExistException(String.format(SUBJECT_ALREADY_EXIST, subjectRequest));
		});
		
		SubjectEntity subject = SubjectEntity.builder().subject(subjectRequest).addedBy(2L).addedDate(Instant.now()).isDeleted(false).build();
		subjectRepository.save(subject);
		return subject.getSubjectId();
	}
	
	public void updateSubject(Long subjectId, String subjectRequest) {
		Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
		subjectEntity.ifPresent(subject ->{
			subject.setSubject(subjectRequest);
			subject.setAddedDate(Instant.now());
			subject.setAddedBy(2L);
			subjectRepository.save(subject);
		});
		throw new SubjectNotFoundException(String.format(SUBJECT_NOT_FOUND, subjectId));
	}

	public List<String> getSubjects() {
		List<SubjectEntity> subjectList=  subjectRepository.findAll();
		List<String> subjects = new ArrayList<String>();
		subjectList.forEach(subjectEntity -> {
			String subject = subjectEntity.getSubject();
			subjects.add(subject);
		});
		return subjects;
	}
	
	public List<String> getSkills(Long subjectId){
		Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
		if(subjectEntity.isPresent()) {
			SubjectEntity subject = subjectEntity.get();
			Optional<List<SkillEntity>> skills = skillRepository.findBySubject(subject);
			//List<String> skillList = new ArrayList<String>();
			List<String> skillList = skills.get().stream().map(skill ->{
				return skill.getSkill();
			}).collect(Collectors.toList());
			return skillList;
		}
		
		throw new SubjectNotFoundException(String.format(SUBJECT_NOT_FOUND, subjectId));
	}
	
	public Long addSkill(Long subjectId, String skill) {
		Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
		if(subjectEntity.isPresent()) {
			Optional<SkillEntity> skillEntity = skillRepository.findBySubjectAndSkillIgnoreCase(subjectEntity.get(),skill);
			if(!skillEntity.isPresent()) {
				SkillEntity skillEn = SkillEntity.builder().addedBy(3L).addedDate(Instant.now()).subject(subjectEntity.get()).skill(skill).isdeleted(false).build();
				skillRepository.save(skillEn);
				return skillEn.getSkillId();
			}
			throw new SkillAlreadyExistException(String.format(SKILL_ALREADY_EXIST,subjectId,skill));
		}
		
		throw new SubjectNotFoundException(String.format(SUBJECT_NOT_FOUND, subjectId));
	}


}
