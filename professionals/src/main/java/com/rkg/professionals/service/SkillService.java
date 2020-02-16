package com.rkg.professionals.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkg.professionals.entities.SubjectEntity;
import com.rkg.professionals.entities.SkillEntity;
import com.rkg.professionals.repository.SubjectRepository;
import com.rkg.professionals.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public void addSkill(String subject, String skill) {
		Optional<SubjectEntity> subjectEntity = subjectRepository.findBySubject(subject);
		SkillEntity skillEntity = SkillEntity.builder().addedBy(3L).addedDate(Instant.now()).subject(subjectEntity.get()).skill(skill).isdeleted(false).build();
		skillRepository.save(skillEntity);
	}
}
