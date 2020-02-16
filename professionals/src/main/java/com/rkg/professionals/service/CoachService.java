package com.rkg.professionals.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkg.professionals.dto.request.CoachRequest;
import com.rkg.professionals.dto.request.CoachSkillRequest;
import com.rkg.professionals.entities.CoachEntity;
import com.rkg.professionals.entities.CoachSkillEntity;
import com.rkg.professionals.entities.CoachSubjectEntity;
import com.rkg.professionals.exception.UserAlreadyExistException;
import com.rkg.professionals.function.CoachConverter;
import com.rkg.professionals.repository.CoachRepository;
import com.rkg.professionals.repository.CoachSkillRepository;
import com.rkg.professionals.repository.CoachSubjectRepository;

@Service
public class CoachService {

	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private CoachSubjectRepository coachSubjectRepository;
	
	@Autowired
	private CoachSkillRepository coachSkillRepository;
	
	private static final String USER_ALREADY_EXIST = "User %s already exist";
	
	public Long addCoach(CoachRequest request) {
		Optional<CoachEntity> coachEntity = coachRepository.findByEmailId(request.getEmailId());
		if(!coachEntity.isPresent()) {
			CoachEntity coach = CoachConverter.createCoachEntity(request);
			CoachEntity entity = coachRepository.save(coach);
			return entity.getCoachId();
		}
		throw new UserAlreadyExistException(String.format(USER_ALREADY_EXIST, request.getEmailId()));
	}
	
	public void addSkill(Long coachId, CoachSkillRequest request) {
		Optional<CoachEntity> coachEntity = coachRepository.findById(coachId);
		CoachEntity coach = coachEntity.get();
		Optional<CoachSubjectEntity> subjectEntity =  coachSubjectRepository.findBySubjectAndCoach(request.getSubject(),coach);
		CoachSubjectEntity subject = null;
		if(!subjectEntity.isPresent()) {
			subject = CoachSubjectEntity.builder().subject(request.getSubject()).coach(coach).build();
			subject = coachSubjectRepository.save(subject);
		}else {
			subject = subjectEntity.get();
		}
		Optional<CoachSkillEntity> coachSkill = coachSkillRepository.findByskillIgnoreCaseAndTypeAndCoachId(request.getSkill(),request.getType(),coachId);
		if(!coachSkill.isPresent()) {
			CoachSkillEntity skill = CoachSkillEntity.builder().coachId(coachId).skill(request.getSkill()).addedBy(1L).addedDate(null)
					.type(request.getType()).fee(request.getFee()).subject(subject).build();
			skill = coachSkillRepository.save(skill);
		}
		coach.getSubjects().add(subject);
		coachRepository.save(coach);
	}
	
}
