package com.rkg.professionals.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkg.professionals.entities.CoachSkillEntity;
import com.rkg.professionals.entities.constant.CoachingType;

@Repository
public interface CoachSkillRepository extends JpaRepository<CoachSkillEntity, Long>{

	Optional<CoachSkillEntity> findByskillIgnoreCaseAndTypeAndCoachId(String skill, CoachingType type, Long coachId);

}
