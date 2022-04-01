package br.com.tcessin.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcessin.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	
	
}
