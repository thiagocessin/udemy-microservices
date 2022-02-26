package br.com.tcessin.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.tcessin.model.Book;
import br.com.tcessin.proxy.CambioProxy;
import br.com.tcessin.repository.BookRepository;
import br.com.tcessin.response.Cambio;

@RestController
@RequestMapping("book-service")
public class BookController {


	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy;
	
//	@GetMapping(value = "/{id}/{currency}")
//	public Book findBook(@PathVariable("id") Long id, 
//						 @PathVariable("currency") String currency) {
//
//		String port = environment.getProperty("local.server.port");
//
//		var book = repository.getById(id);
//		
//		if(book == null) throw new RuntimeException("Book not found");
//		
//		book.setEnvironment(port);
//		
//		
//		
//		HashMap<String, String> params = new HashMap<>();
//		params.put("amount", book.getPrice().toString());
//		params.put("from", "USD");
//		params.put("to", currency);
//		
//		
//		
//		var response  = new RestTemplate()
//			.getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class, params);
//		
//		Cambio cambio = response.getBody();
//		book.setPrice(cambio.getConvertedValue());
//		
//		
//		return book;
//
//	}
	
	
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, 
			@PathVariable("currency") String currency) {
		
		String port = environment.getProperty("local.server.port");
		
		var book = repository.getById(id);
		
		if(book == null) throw new RuntimeException("Book not found");
		
		book.setEnvironment(port +"FEIGN");
			
		
		Cambio cambio = proxy.getCambio(book.getPrice(),"USD", currency);
		book.setPrice(cambio.getConvertedValue());
		
		
		return book;
		
	}

}
