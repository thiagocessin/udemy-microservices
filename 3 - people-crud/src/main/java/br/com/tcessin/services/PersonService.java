package br.com.tcessin.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.tcessin.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public void findById(String id) {
		
	}
	
}
