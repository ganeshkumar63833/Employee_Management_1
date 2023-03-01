package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.model.Performance;
import com.ems.service.PerformanceService;

@Controller
public class PerformanceController {

	@Autowired
	private PerformanceService performanceService;
	
	@GetMapping("/performance")
	public String performance(Model model) {
		
		  model.addAttribute("listEmployeePerformance",
		  performanceService.getAllPerformance()); return "performance";
		 
	}
	
	@GetMapping("/showFormForUpdatePerformance/{id}")
	public String showFormForUpdatePerformance(@PathVariable ( value = "id") long id, Model model) {
		
		Performance performance = performanceService.getPerformanceById(id);
		
		model.addAttribute("performance", performance);
		return "update_performance";
	}
	
	@PostMapping("/savePerformance")
	public String savePerformance(@ModelAttribute("performance") Performance performance) {
		
		performanceService.savePerformance(performance);
		return "redirect:/performance";
	}
	
	@GetMapping("/showNewEmployeePerformanceForm")
	public String showNewEmployeePerformanceForm(Model model) {
		
		Performance performance = new Performance();
		model.addAttribute("performance", performance);
		return "new_performance";
	}
	
	@GetMapping("/deleteEmployeePerformance/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		this.performanceService.deletePerformanceById(id);
		return "redirect:/performance";
	}
	
}
