package com.rkg.professionals.function;

import com.rkg.professionals.dto.request.CoachRequest;
import com.rkg.professionals.entities.CoachEntity;
import com.rkg.professionals.entities.constant.Role;

public class CoachConverter {
	
	public static CoachEntity createCoachEntity(CoachRequest request) {
		CoachEntity coach = CoachEntity.builder().firstName(request.getFirstName())
				.lastName(request.getLastName()).emailId(request.getEmailId()).city(request.getCity())
				.gender(request.getGender()).background(request.getBackground()).address(request.getAddress())
				.contactNumber(request.getContactNumber()).methodology(request.getMethodology()).dob(request.getDob())
				.title(request.getTitle()).role(Role.COACH).build();
		return coach;
	}

}
