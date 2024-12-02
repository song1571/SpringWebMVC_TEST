package com.mingi.controller.initbinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mingi.controller.initbinder.ChangeEmailController;

@Controller
@RequestMapping("/initbinder")
public class ChangeEmailController {
	
	private static final Logger log = LoggerFactory.getLogger(ChangeEmailController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("oldEmailAddress", "newEamilAddress");
	}
	
	@PostMapping("/changeEmail")
	public String changeEmail(@RequestParam("oldEmailAddress") String oldEmail,
			@RequestParam("newEmailAddress") String newEmail,
			Model model) {
		
		if(oldEmail.equalsIgnoreCase(newEmail)) {
			model.addAttribute("message", "The new email address must be different for the old on");
		}
		else {
			model.addAttribute("message", "Email successfully changed from " + oldEmail + " to " + newEmail);
		}
		return "initbinder/changeEmailSuccess";
	}

}
