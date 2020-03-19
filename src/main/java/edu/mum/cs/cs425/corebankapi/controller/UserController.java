package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 9541a3363de0d441b2d40c9730430496de0819bc

import edu.mum.cs.cs425.corebankapi.model.setting.User;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@PostMapping(value = "createuser", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response createUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			
		}catch (Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		
		return new Response(200, "succesful", null);
	}
	
	@GetMapping(value = "getallusers")
	public Response getallUsers() {
		try {
			return new Response(200, "successful", userService.getUsers());
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		
	}
	
	@GetMapping(value ="getuser")
	public Response getUser(@RequestParam Long id) {
		try {
			return new Response(200,"successful", Arrays.asList(userService.getUser(id)));
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
			
		}
		
		
	}
	
	
	@PostMapping(value= "lockuser")
	public Response lockUser(@RequestParam Long id) {
		try {
		
			return new Response(200, "succesful", null);
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		
	}
	
	@GetMapping(value= "edituser")
	public Response editUser(@RequestParam Long id) {
		try {
			return new Response(200, "succesful", Arrays.asList(userService.editUser(id)));
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);	
		}
	}
		
	@PostMapping(value = "login", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response login(@RequestBody User user) {
		try {
			User u = userService.login(user.getUserName(), user.getPassword());
			if(u == null)
				return new Response(400, "Invalid User", null);
			u.setPassword(null);
			return new Response(200, "login successful", Arrays.asList(u));
		}catch (Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}

}
