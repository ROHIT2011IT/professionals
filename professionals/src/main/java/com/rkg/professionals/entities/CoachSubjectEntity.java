package com.rkg.professionals.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="coach_subject")
public class CoachSubjectEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="coach_subject_id")
	private Long coachSujectId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="coach_id")
	private CoachEntity coach;
	
	@Column(name="subject")
	private String subject;
	
	@OneToMany(mappedBy="subject", cascade=CascadeType.PERSIST)
	private final List<CoachSkillEntity> skills = new ArrayList<CoachSkillEntity>();
}
