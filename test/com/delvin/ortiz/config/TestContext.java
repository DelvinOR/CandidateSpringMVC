package com.delvin.ortiz.config;


import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.delvin.ortiz.candidate.CandidateService;

@Configuration
public class TestContext {
	
	@Bean
	public CandidateService candidateService() {
		return Mockito.mock(CandidateService.class);
	}
}
