package com.delvin.ortiz.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateService {
	@Autowired CandidateRepository repo;
	
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
