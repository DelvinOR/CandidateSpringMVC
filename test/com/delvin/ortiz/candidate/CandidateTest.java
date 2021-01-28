package com.delvin.ortiz.candidate;

import org.junit.Test;
import static org.junit.Assert.*;

public class CandidateTest {
	
	@Test
	public void testCandidate() {
		Candidate cand = new Candidate();
		
		String result = cand.fooMethod();
		
		assertEquals("foo", result);
	}
}
