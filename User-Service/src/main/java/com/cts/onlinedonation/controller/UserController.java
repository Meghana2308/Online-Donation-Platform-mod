package com.cts.onlinedonation.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.onlinedonation.entity.User;
import com.cts.onlinedonation.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/user")

@Api(value="The UserController", description="Rest controller for user")
public class UserController {
	private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="Post all user",
			produces="A list of user",
			notes="Hit this URL to get all user"
			)

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		logger.info("registering user {}");
		userService.addUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User login) throws ServletException {
		logger.info("user login {}");

		String jwtToken = "";

		if (login.getEmail() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getEmail();
		String password = login.getPassword();

		User user = userService.getByEmail(email);

		if (user == null) {
			
			throw new ServletException("User email not found.");
			
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}
}
