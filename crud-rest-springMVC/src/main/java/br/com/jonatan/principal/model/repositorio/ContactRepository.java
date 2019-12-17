package br.com.jonatan.principal.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jonatan.principal.model.modelo.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	
} 
