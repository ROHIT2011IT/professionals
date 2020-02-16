package com.rkg.professionals.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkg.professionals.entities.CoachEntity;
import com.rkg.professionals.entities.CoachSubjectEntity;

@Repository
public interface CoachSubjectRepository extends JpaRepository<CoachSubjectEntity, Long>{

	Optional<CoachSubjectEntity> findBySubjectAndCoach(String subject, CoachEntity coachId);

}
