package com.mingi.controller.valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingi.model.AccountForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valid")
public class AccountController {
	
	@PostMapping("/accounts")
	public String handleAccount(@Valid @ModelAttribute AccountForm form, Errors errors, Model model) {

		if(errors.hasErrors() ) {
			return "valid/accountForm";
		}
		model.addAttribute("Message", "Account created successfully!");
		return "model/accountView";
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
		
		return ResponseEntity.ok("User created successfully!");
	}

}
