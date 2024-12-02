package com.mingi.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetModelTestPageController {
	
	@GetMapping("/usingModelAttributeonmethodparameter")
	public String getTestUsingModelAttributeOnMethodParameter() {
		System.out.println("getTestUsingModelAtrributeOnMethodParameter");
		return "model/accountForm";
	}
	
	@GetMapping("/addreturnvalueasmodelproperty")
	public String getTestAddReturnValueAsModel() {
		System.out.println("getTestAddReturnValueAsModel");
		return "model/accountFormOnlyName";
	}

}