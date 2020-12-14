package com.rpete.mvc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Size(min = 5, max = 200)
    private String Title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "publications", 
        joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    
    private List<Publisher> publishers;
    
    public Book() {
    	
    }

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

    
    
}