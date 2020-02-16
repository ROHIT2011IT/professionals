package com.rkg.professionals.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkg.professionals.commons.RestConstants;
import com.rkg.professionals.dto.request.CoachRequest;
import com.rkg.professionals.dto.request.CoachSkillRequest;
import com.rkg.professionals.entities.CoachEntity;
import com.rkg.professionals.entities.CoachSubjectEntity;
import com.rkg.professionals.entities.CoachSkillEntity;
import com.rkg.professionals.entities.constant.CoachingType;
import com.rkg.professionals.entities.constant.Gender;
import com.rkg.professionals.service.CoachService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Coach Management API", description = "API for coach management")
@RestController("coachControllerV1")
@RequestMapping(RestConstants.VERSION_ONE + "/coaches")
public class CoachController {

	@Autowired
	private CoachService coachService;
	
	@ApiOperation(value = "Create Coach")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful creation of coach."),
            @ApiResponse(code = 409, message = "Conflict with existing coach."),
            @ApiResponse(code = 412, message = "Validation failed coach."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping
	public Long addCoach(@RequestBody CoachRequest request) {
		return coachService.addCoach(request);
	}
	
	@ApiOperation(value = "Add Coach skill")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful addition of coach skill."),
            @ApiResponse(code = 409, message = "Conflict with existing coach skill."),
            @ApiResponse(code = 412, message = "Validation failed skill."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping("/{coachId}")
	public void addCoachSkill(@PathVariable("coachId") Long coachId,@RequestBody CoachSkillRequest request) {
		coachService.addSkill(coachId, request);
	}
	
}