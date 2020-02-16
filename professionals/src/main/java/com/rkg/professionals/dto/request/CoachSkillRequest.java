package com.rkg.professionals.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.rkg.professionals.dto.request.CoachRequest.CoachRequestBuilder;
import com.rkg.professionals.entities.constant.CoachingType;
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
@ApiModel("CoachSkillRequest")
public class CoachSkillRequest {
	
	@NotNull(message = "Subject is required")
	@ApiModelProperty(value = "subject")
	private String subject;
	
	@NotNull(message = "Skill Name is required")
	@ApiModelProperty(value ="skill")
	private String skill;
	
	@NotNull(message = "CoachingType is required")
	@ApiModelProperty(value ="coaching type")
	private CoachingType type;
	
	@NotNull(message = "fee is required")
	@ApiModelProperty(value ="fee")
	private Long fee;
}
