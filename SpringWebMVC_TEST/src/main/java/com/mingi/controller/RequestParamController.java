package com.mingi.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
	
	@GetMapping("/requestparam")
	public String handleRequestParam(@RequestParam (value = "name", required = true) String name) {
		return "Hello, " + name + "!"; // 단일 파라미터 처리
	}
	
	@GetMapping("/search")
	public List<String> searchPets(@RequestParam("type") String[] types) {
		return Arrays.asList(types); // 배열 파라미터 처리
	}
	
	@PostMapping(path="/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Map<String, String> processForm(@RequestParam MultiValueMap<String, String> params) {
		Map<String, String> response = new HashMap<>();
		
		for(String key : params.keySet()) {
			response.put(key, String.join(",", params.get(key)));
		}
		return response;
	}
}
