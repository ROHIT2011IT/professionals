package com.rkg.professionals.entities;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="skill")
public class SkillEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_id")
	private Long SkillId;
	
	@Column(name="skill")
	private String skill;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="subject_id")
	private SubjectEntity subject;
	
	@Column(name="added_date")
	private Instant addedDate;
	
	@Column(name="added_by")
	private Long addedBy;
	
	@Column(name="is_deleted")
	private Boolean isdeleted;
	
	@ManyToMany(mappedBy="skillOpted")
	private List<StudentEntity> students;
}
