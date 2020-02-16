package com.rkg.professionals.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkg.professionals.entities.SkillEntity;
import com.rkg.professionals.entities.SubjectEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long>{

	SkillEntity findBySkill(String skill);

	Optional<List<SkillEntity>> findBySubject(SubjectEntity subject);

	Optional<SkillEntity> findBySubjectAndSkillIgnoreCase(SubjectEntity subjectEntity, String skill);

}
