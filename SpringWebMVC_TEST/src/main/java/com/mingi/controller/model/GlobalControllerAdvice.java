package com.mingi.controller.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "com.mingi.controller.model")
public class GlobalControllerAdvice {

	@ModelAttribute
	public void addGlobalAttributes(Model model) {
		System.out.println("called addGlobalAttributes");
		model.addAttribute("globalMessage", "Welcome to our website!");
	}
}
