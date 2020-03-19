package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.cs425.corebankapi.model.setting.UtilitySetting;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IUtilitySettingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class UtilitySettingController {
	
	@Autowired
	private IUtilitySettingService utilitySettingService;
	
	@PostMapping(value = "createutilitysetting", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response saveUtilitySetting(@RequestBody UtilitySetting utilitySetting) {
		
		try {
			utilitySettingService.saveUtilitySetting(utilitySetting);
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
		return new Response(200, "succesful", null);
		
	}
	
	@GetMapping(value ="getutilitysetting")
	public Response getUtilitySetting(@RequestParam Long id) {
		try {
			return new Response(200, "succesful", Arrays.asList(utilitySettingService.getUtilitySetting(id)));
			
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
			
		}
	}
	@GetMapping(value="getallutilitysettings")
	public Response getAllUtilitySettings(@RequestParam Long id) {
		
		try {
			return new Response(200, "succesful", utilitySettingService.getAllUtilitySettings());
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
			
		}
	}
	
	@GetMapping(value="editutilitysetting")
	public Response editUtilitySetting (Long id) {
		try {
			return new Response(200, "succesful", Arrays.asList(utilitySettingService.editUtilitySetting(id)));
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	@GetMapping(value="deleteutilitysetting")
	public Response deleteUtilitySetting(@RequestParam Long id) {
		try {
			utilitySettingService.deleteUtilitySetting(id);
			
		}catch(Exception ex) {
			
			return new Response(400, ex.getMessage(), null);
			
		}
		return new Response(200, "succesful", null);
	}

}
