package br.com.tcessin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcessin.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	
	

}
