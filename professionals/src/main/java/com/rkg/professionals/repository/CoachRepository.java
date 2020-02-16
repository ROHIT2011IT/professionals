package com.rkg.professionals.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkg.professionals.entities.CoachEntity;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long>{

	Optional<CoachEntity> findByEmailId(String emailId);

}
