package com.rkg.professionals.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.rkg.professionals.entities.constant.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class StudentEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="role")
	private String role;
	
	@Column(name="profile_pic")
	private String profilePic;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="student_skill", 
	joinColumns= {@JoinColumn(name="student_id")},
	inverseJoinColumns= {@JoinColumn(name="sub_skill_id")})
	private List<SkillEntity> skillOpted;

}

