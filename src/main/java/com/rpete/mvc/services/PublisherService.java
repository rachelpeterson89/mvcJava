package com.rpete.mvc.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.rpete.mvc.models.Publisher;
import com.rpete.mvc.repositories.PublisherRepository;

@Service
public class PublisherService {
	public final PublisherRepository publisherRepository;
	
	public PublisherService(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}

	public void addPublisher(@Valid Publisher publisher) {
		publisherRepository.save(publisher);		
	}

	public List<Publisher> allPublishers() {
		return publisherRepository.findAll();
	}
}
