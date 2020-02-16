package com.rkg.professionals.dto.request;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rkg.professionals.entities.constant.Gender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("CoachRequest")
public class CoachRequest {

	@NotNull(message = "FirstName is required")
	@ApiModelProperty(value = "First Name")
	private String firstName;
	
	@NotNull(message = "Last Name is required")
	@ApiModelProperty(value = "Last Name")
	private String lastName;
	
	@NotNull(message = "Gender is required")
	@ApiModelProperty(value = "Gender")
	private Gender gender;
	
	@NotNull(message = "DOB is required")
	@ApiModelProperty(value = "DOB")
	private LocalDate dob;
	
	@NotNull(message = "emailId is required")
	@ApiModelProperty(value = "emailId which currently being used to uniquely identify the user")
	private String emailId;
	
	@NotNull(message = "contactNumber is required")
	@ApiModelProperty(value = "contactNumber")
	private String contactNumber;
	
	@NotNull(message = "City is required")
	@ApiModelProperty(value = "City")
	private String city;
	
	@ApiModelProperty(value = "address")
	private String address;
	
	@ApiModelProperty(value = "background")
	private String background;
	
	@ApiModelProperty(value = "title")
	private String title;
	
	@ApiModelProperty(value = "methodology")
	private String methodology;
}
