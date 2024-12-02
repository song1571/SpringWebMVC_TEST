package com.mingi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mingi.model.Pet;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pet")
@SessionAttributes("petList")
public class SessionAttributesController {
	
	private static final Logger logger = Logger.getLogger(SessionAttributesController.class.getName());
	
	@ModelAttribute("petList")
	public List<Pet> setUpPetList(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Pet> petList = (List<Pet>) session.getAttribute("petList");
		
		if(petList == null) {
			petList = new ArrayList<>();
			session.setAttribute("petList", petList);
			logger.info("Created new petList as it was null and saved in session");
		}
		else {
			logger.info("Loaded existing petList from session");
		}
		
		return petList;
	}
	
	@GetMapping("/new")
	public String ShowNewPetFrom(Model model) {
		model.addAttribute("Pet", new Pet());
		return "methodarguments/newPetForm"; // JSP 파일 변환
	}
	
	
	@PostMapping("/new")
	public String addNewPet(@Valid Pet pet, @ModelAttribute("petList") List<Pet> petList, 
			BindingResult result, SessionStatus status) {
		
		if(result.hasErrors()) {
			return "methodarguments/newPetForm"; // 유효성 검사 실패시 다시 폼으로 이동
		}
		
		OptionalInt maxPetId = petList.stream().mapToInt(p -> Integer.parseInt(p.getPetId())).max();
		
		int newPetId = maxPetId.orElse(0) + 1;
		pet.setPetId(String.valueOf(newPetId));
		
		petList.add(pet);
		logger.info("Added new pet to petList: " + pet);
		
		return "redirect:/pet/list"; // Pet 목록 페이지로 리다이렉트
		
	}
	
	@GetMapping("/list")
	public String showPetList (@ModelAttribute("petList") List<Pet> petList, Model model) {
		
		if(petList != null && !petList.isEmpty()) {
			logger.info("Loaded petList from sessuin: " + petList);
			model.addAttribute("petList", petList);
		}
		else {
			logger.info("No pets from in session.");
			model.addAttribute("message", "No pets found in session.");
		}
		
		return "methodarguments/petList";
	}
}
