package com.rkg.professionals.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rkg.professionals.entities.constant.CoachingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="coach_skill")
public class CoachSkillEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="skill_id")
	private Long skillId;
	
	@NotNull
	@Column(name="coach_id")
	private Long coachId;
	
	@NotNull
	@Column(name="skill")
	private String skill;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private CoachingType type;
	
	@Column(name="fee")
	private Long fee;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private Long addedBy;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="subject_id")
	private CoachSubjectEntity subject;
}
