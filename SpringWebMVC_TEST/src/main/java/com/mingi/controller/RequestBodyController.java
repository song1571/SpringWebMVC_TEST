package com.mingi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mingi.model.Account;

import jakarta.validation.Valid;

@Controller
public class RequestBodyController {

	@PostMapping("/accounts")
	public ResponseEntity<String> handle(@Valid @RequestBody Account account, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("Validation failed: " + errors);
			return ResponseEntity.badRequest().body("Validation failed");
		}
		System.out.println("Account Name: " + account.getName());
		return ResponseEntity.ok("Account successfully processed");
	}
}
