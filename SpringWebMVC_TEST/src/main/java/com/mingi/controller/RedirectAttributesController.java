package com.mingi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RedirectAttributesController {
	
	@PostMapping("/submitForm")
	public String submitForm(@RequestParam(value="name") String name, 
			@RequestParam(value="age") int age, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("name", name);
		redirectAttributes.addAttribute("age", age);
		
		redirectAttributes.addFlashAttribute("successMessage", "From submitted successfully!");
		
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String success(@RequestParam(value="name") String name, 
			@RequestParam(value="age") int age, Model model) {
		return "methodarguments/successPage";
	}
}
