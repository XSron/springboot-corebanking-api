package edu.mum.cs.cs425.corebankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IPaycheckService;

@RestController
@RequestMapping("/api")
public class PaycheckController {
	@Autowired
	private IPaycheckService paycheckService;
	@PostMapping(value = "makepaycheck", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response makePaycheck(@RequestBody Paycheck paycheck) {
		try {
			paycheckService.savePaycheck(paycheck);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@GetMapping(value = "getallpaychecks")
	public Response getAllPaychecks() {
		try {
			return new Response(200, "succeed", paycheckService.getPaycheck());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
}
