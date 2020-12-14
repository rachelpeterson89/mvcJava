package com.rpete.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rpete.mvc.models.Publisher;
import com.rpete.mvc.services.PublisherService;

@Controller
public class PublisherController {
	public final PublisherService publisherService;
	
	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@PostMapping("/publishers")
	public String addPublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			publisherService.addPublisher(publisher);
			return "redirect:/";
		}
	}

}