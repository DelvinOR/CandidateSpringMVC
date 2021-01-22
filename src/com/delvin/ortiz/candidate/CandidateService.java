package com.delvin.ortiz.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @Transaction tells Spring Data JPA to utilize these methods for transaction management
@Service
@Transactional
public class CandidateService {
	
	// Here, a CandidateRepository instance will be injected into this class
	// We see this an example of Dependency Injection
	@Autowired CandidateRepository repo;
	
	// All of these methods are for CRUD operations
	// These methods provide decoupling the business layer from the repository/DAO layer
	public void save(Candidate candidate) {
		repo.save(candidate);
	}
	
	public List<Candidate> listAll(){
		return (List<Candidate>) repo.findAll();
	}
	
	public Candidate get(Long jid) {
		return repo.findById(jid).get();
	}
	
	public void delete(Long jid) {
		repo.deleteById(jid);
	}
	
	public List<Candidate> search(String search_word){
		return repo.search(search_word);
	}
}
