package com.rkg.professionals.entities;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="subject")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id")
	private Long subjectId;
	
	@Column(name="subject")
	private String subject;
	
	@OneToMany(mappedBy="subject", cascade=CascadeType.PERSIST)
	private Set<SkillEntity> skill;
	
	@Column(name="added_date")
	private Instant addedDate;	
	
	@Column(name="added_by")
	private Long addedBy;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
}
