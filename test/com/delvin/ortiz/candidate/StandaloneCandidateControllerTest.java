package com.delvin.ortiz.candidate;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.atMost;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(MockitoJUnitRunner.class)
public class StandaloneCandidateControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private CandidateService candidateServiceMock;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new CandidateController(candidateServiceMock))
				.setViewResolvers(getViewResolver())
				.build();
	}
	
	private InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// This method allows us to test the CandidateController requestMapping("/") method handler
	@Test
	public void listAll_ShouldCandidateRecordsToModelAndRenderIndex() throws Exception {
		Candidate candidate = new Candidate("delvin", "delvin@email.com");
		
		when(candidateServiceMock.listAll()).thenReturn(Arrays.asList(candidate));
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk());
		
		verify(candidateServiceMock, Mockito.atLeast(1)).listAll();
		verifyNoMoreInteractions(candidateServiceMock);
	}
}
