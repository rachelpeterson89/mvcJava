package com.rpete.mvc.services;

import org.springframework.stereotype.Service;
import com.rpete.mvc.models.Publication;
import com.rpete.mvc.repositories.PublicationRepository;

@Service
public class PublicationService {
	private final PublicationRepository publicationRepository;
	
	public PublicationService(PublicationRepository publicationRepository) {
		this.publicationRepository = publicationRepository;
	}
	
	public void createPublication(Publication publication) {
		publicationRepository.save(publication);
	}
}
