package com.mingi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetTestPageController {

	
	@GetMapping("/requestparam")
	public String getTestRequestParam() {
		System.out.println("getTestRequestParam");
		return "methodarguments/requestparamTest"; // JSP 파일 변환
	}
	
	@GetMapping("/requestheader")
	public String getTestRequestHeader() {
		System.out.println("getTestRequestHeader");
		return "methodarguments/requestheaderTest"; // JSP 파일 변환
	}
	
	@GetMapping("/sessionattributes") // 안씀
	public String getTestSessionAttributes() {
		System.out.println("getTestSessionAttribute");
		return "methodarguments/newPetForm"; // JSP 파일 변환
	}
	
	@GetMapping("/sessionattribute")
	public String getTestSessionAttribute() {
		System.out.println("getTestSessionAttribute");
		return "methodarguments/sessionattributeTest"; // JSP 파일 변환
	}
	
	@GetMapping("/requestbody")
	public String getTestRequestBody() {
		System.out.println("getTestRequestBody");
		return "methodarguments/requestbodyTest"; // JSP 파일 변환
	}
	
	@GetMapping("/responsebody")
	public String getTestResponseBody() {
		System.out.println("getTestResponseBody");
		return "methodarguments/responsebodyTest"; // JSP 파일 변환
	}
	
	@GetMapping("/redirectattribute")
	public String getTestRedirectAttribute() {
		System.out.println("getTestRedirectAttribute");
		return "methodarguments/redirectattributesTest"; // JSP 파일 변환
	}
	
}
