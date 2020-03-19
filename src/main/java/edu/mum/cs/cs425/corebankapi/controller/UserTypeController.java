package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.cs425.corebankapi.model.setting.UserType;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IUserTypeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class UserTypeController {
	
	@Autowired
	private IUserTypeService userTypeService;
	
	@PostMapping(value = "createusertype", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response saveUserType(@RequestBody UserType userType) {
		try {
			userTypeService.saveUserType(userType);
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
		}
		
		return new Response(200, "succesful", null);
		
	}
	
	
	@GetMapping(value="getusertype")
	public Response getUserType(@RequestParam Long id) {
		try {
			return new Response(200, "succesful", Arrays.asList(userTypeService.getUserType(id)));
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	@GetMapping(value = "getallusertypes")
	public Response getallUserTypes() {
		
		try {
			
			return new Response(200, "successful", userTypeService.getUserTypes());
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
			
			
		}
		
	}
	
	@GetMapping(value="editusertype")
	public Response editUserType(@RequestParam Long id) {
		try {
			return new Response(200, "succesful", Arrays.asList(userTypeService.getUserType(id)));
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
			
		}
	}
	
	
	
	

}
