package com.rpete.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.mvc.models.Publication;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {
	List<Publication> findAll();
}
