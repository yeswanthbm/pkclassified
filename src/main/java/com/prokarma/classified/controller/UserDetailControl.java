package com.prokarma.classified.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.classified.model.UserDetail;
import com.prokarma.classified.service.UserDetailService;

@RestController
@RequestMapping("/user")
public class UserDetailControl {
	
	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public UserDetail getUserDetails(@PathVariable String userId) {
		return userDetailService.getUser(userId);
	}
	
}
