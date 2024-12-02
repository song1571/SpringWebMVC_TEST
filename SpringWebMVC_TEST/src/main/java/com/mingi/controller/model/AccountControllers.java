package com.mingi.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingi.model.Account;

@Controller
@RequestMapping("/model")
public class AccountControllers {

	@PostMapping("/accounts")
	public String handleAccount(@ModelAttribute Account account) {
		System.out.println("Account Name: " + account.getName());
		System.out.println("Account Email: " + account.getEmail());
		return "model/accountView";
	}
	
	@GetMapping("/account/{name}")
	@ModelAttribute("myAccount")
	public Account getAccount(@PathVariable("name") String name) {
		Account account = new Account(name, "sweokitec@gmail.com");
		return account;
	}
}
