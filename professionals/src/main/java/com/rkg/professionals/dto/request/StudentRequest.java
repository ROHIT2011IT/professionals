package com.rkg.professionals.dto.request;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

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
@ApiModel("StudentRequest")
public class StudentRequest{
	
	@NotNull(message = "FirstName is required")
	@ApiModelProperty(value = "First Name")
	private String firstName;
	
	@NotNull(message = "LastName is required")
	@ApiModelProperty(value = "First Name")
	private String lastName;
	
	@NotNull(message = "Gender is required")
	@ApiModelProperty(value = "Gender")
	private Gender gender;
	
	@ApiModelProperty(value = "Date of Birth")
	private LocalDate dob;
	
	@NotNull(message = "EmailId is required")
	@ApiModelProperty(value = "EmailId")
	private String emailId;
	
	@NotNull(message = "Contact Number is required")
	@ApiModelProperty(value = "Contact Number")
	private String contactNumber;	
}
