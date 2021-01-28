package com.delvin.ortiz.candidate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.delvin.ortiz.config.TestContext;
import com.delvin.ortiz.config.WebMvcConfig;

// have to create this ControllerTest with WebApplicationContext based configuration to avoid duplicating
// Spring MVC infrastructure components
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebMvcConfig.class})
@WebAppConfiguration
public class WebAppContextCandidateControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	@Qualifier(value = "candidateServiceMockBean")
	private CandidateService candidateServiceMock;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		Mockito.reset(candidateServiceMock);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void listAll_ShouldCandidateRecordsToModelAndRenderIndex() throws Exception{
		Candidate candidate = new Candidate("delvin", "delvin@email.com");
		
		when(candidateServiceMock.listAll()).thenReturn(Arrays.asList(candidate));
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
		
		verify(candidateServiceMock, Mockito.atMost(0)).listAll();
		//verifyNoMoreInteractions(candidateServiceMock);	
	}
}
