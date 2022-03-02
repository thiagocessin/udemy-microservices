package br.com.tcessin.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcessin.hrworker.entities.Worker;
import br.com.tcessin.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	
	@Autowired
	private WorkerRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> lista = repository.findAll();
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		Worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok(obj);
		
		
	}
	
}
