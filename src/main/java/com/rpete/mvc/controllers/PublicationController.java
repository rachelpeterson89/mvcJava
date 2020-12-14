package com.rpete.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rpete.mvc.models.Publication;
import com.rpete.mvc.services.PublicationService;

@Controller
public class PublicationController {
	private final PublicationService publicationService;
	
	public PublicationController(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	
	@PostMapping("/publications")
	public String createPublications(@Valid @ModelAttribute("publications") Publication publications, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			publicationService.createPublication(publications);
			return "redirect:/";
		}
	}
}