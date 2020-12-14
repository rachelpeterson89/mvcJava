package com.rpete.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.mvc.models.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
	List<Publisher> findAll();
}
