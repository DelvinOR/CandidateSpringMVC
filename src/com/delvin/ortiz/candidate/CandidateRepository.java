package com.delvin.ortiz.candidate;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// Spring Data JPA will automatically generate all of the implementation code
public interface CandidateRepository extends CrudRepository<Candidate, Long>{

	@Query (value = "SELECT c FROM Candidate c WHERE c.jid LIKE '%' || :search_word || '%'"
			+ " OR c.name LIKE '%' || :search_word || '%'"
			+ " OR c.email LIKE '%' || :search_word || '%'" )
	public List<Candidate> search(@Param("search_word") String search_word);
}
