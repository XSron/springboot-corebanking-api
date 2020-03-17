package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.setting.Rate;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IRateService;

@RestController
@RequestMapping("/api")
public class RateController {
	
	@Autowired
	private IRateService rateService;
	
	@PostMapping(value = "createrate", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response saveRate(@RequestBody Rate rate) {
		try {
			rateService.saveRate(rate);
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		return new Response(200, "succesful", null);
		
	}
	
	@GetMapping(value="getrate")
	public Response getRate(@RequestParam Long id) {
		try {
			return new Response(200, "successful", Arrays.asList(rateService.getRate(id)));
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
	}
	
	@GetMapping(value="getallrates")
	public Response getRates() {
		try {
			return new Response(200, "succesful", rateService.getRates());
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	@GetMapping(value="editrate")
	public Response editRate(@RequestParam Long id) {
		try {
			return new Response(200, "successful", Arrays.asList(rateService.getRate(id)));
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		
	}
	
	@GetMapping(value="deleterate")
	public Response  deleteRate(Long id) {
		try {
			rateService.deleteRate(id);
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		
		return new Response(200, "succesful", null);
		
	}
	

}
