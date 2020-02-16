package com.rkg.professionals.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rkg.professionals.entities.constant.Gender;
import com.rkg.professionals.entities.constant.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="coach")
public class CoachEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="coach_id")
	private Long coachId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="email_id", unique=true)
	private String emailId;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Column(name="profile_pic")
	private String profilePic;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="background")
	private String background;
	
	@Column(name="title")
	private String title;
	
	@Column(name="methodology")
	private String methodology;
	
	@OneToMany(mappedBy="coach", cascade=CascadeType.PERSIST)
	private final List<CoachSubjectEntity> subjects = new ArrayList<CoachSubjectEntity>();
	
}
