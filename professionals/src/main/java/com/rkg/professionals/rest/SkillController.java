package com.rkg.professionals.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkg.professionals.commons.RestConstants;
import com.rkg.professionals.service.SkillService;
import com.rkg.professionals.service.SubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Skill Management API", description = "API for Skill management")
@RestController("skillControllerV1")
@RequestMapping(RestConstants.VERSION_ONE + "/subjects")
public class SkillController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SkillService skillService;
	
	@ApiOperation(value = "Add Subject")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful addition of subject."),
            @ApiResponse(code = 412, message = "Conflict with existing coach skill."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping("/{subject}")
	public ResponseEntity<String> createSubject(@PathVariable("subject") String subject) {
		Long subjectId = subjectService.createSubject(subject);
		return ResponseEntity.status(HttpStatus.CREATED).body("subject Id:"+subjectId);
	}
	
	@PutMapping("/{subjectId}/{subject}}")
	public void updateSubject(@PathVariable("subjectId") Long subjectId, @PathVariable("subject") String subject) {
		subjectService.updateSubject(subjectId, subject);
	}
	
	@GetMapping
	public List<String> getSubjects() {
		return subjectService.getSubjects();
	}

	@GetMapping("/{subjectId}")
	public List<String> getSkills(@PathVariable("subjectId") Long subjectId){
		return subjectService.getSkills(subjectId);
	}
	
	@PostMapping("/{subjectId}/{skill}")
	public ResponseEntity<String> addSkill(@PathVariable("subjectId") Long subjectId, @PathVariable("skill") String skill) {
		Long skillId = subjectService.addSkill(subjectId, skill);
		return ResponseEntity.status(HttpStatus.CREATED).body("skill Id:"+skillId);
	}
}
