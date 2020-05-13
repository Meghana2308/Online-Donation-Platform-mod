package com.cts.onlinedonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.onlinedonation.entity.User;
import com.cts.onlinedonation.service.UserService;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	
	  @RequestMapping(value = "/user/email", method = RequestMethod.POST) public
	  User findByEmail(@RequestBody String email) { return
	  userService.getByEmail(email); }
  
	  @RequestMapping(value = "/user/update", method = RequestMethod.POST) public
	  User updateUser(@RequestBody User user) { return userService.addUser(user); }
	 
}
