package com.delvin.ortiz.candidate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Controller class handles all client requests and
// Returns a ModelAndView object when needed or a String
// for the appropriate View component file
@Controller
public class CandidateController {
	
	// Instance of Customer service is injected
	//@Autowired
	private CandidateService candidateService;
	
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Candidate> candidate_list = candidateService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("candidate_list", candidate_list);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCandidateForm(Map<String,Object> model) {
		Candidate candidate = new Candidate();
		model.put("candidate", candidate);
		return "new_candidate";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
		candidateService.save(candidate);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCandidateForm(@RequestParam long jid) {
		ModelAndView mav = new ModelAndView("edit_candidate");
		Candidate candidate = candidateService.get(jid);
		mav.addObject("candidate", candidate);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCandidate(@RequestParam long jid) {
		candidateService.delete(jid);
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public  ModelAndView search(@RequestParam String search_word) {
		List<Candidate> result = candidateService.search(search_word);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result",result);
		
		return mav;
	}
		
	
}
