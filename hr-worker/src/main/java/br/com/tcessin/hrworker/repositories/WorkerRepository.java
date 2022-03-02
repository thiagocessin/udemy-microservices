package br.com.tcessin.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcessin.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
