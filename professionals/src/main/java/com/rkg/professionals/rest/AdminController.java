package com.rkg.professionals.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkg.professionals.commons.RestConstants;

@RestController("adminControllerV1")
@RequestMapping(RestConstants.VERSION_ONE + "/subjects")
public class AdminController {

	public void addField(String fieldName) {
		
	}
}
