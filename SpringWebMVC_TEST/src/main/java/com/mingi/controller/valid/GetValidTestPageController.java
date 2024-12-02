package com.mingi.controller.valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetValidTestPageController {

	@GetMapping("/valid")
	public String getTestValid() {
		System.out.println("getTestValid");
		return "valid/accountForm";
	}
	
	@GetMapping("/validwithjson")
	public String getTestValidWithJSON() {
		System.out.println("getTestValidWithJSON");
		return "valid/accountFormWithJSON";
	}
}
