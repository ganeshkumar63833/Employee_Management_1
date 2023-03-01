package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Performance;
import com.ems.repository.PerformanceRepository;

@Service
public class PerformanceServiceImpl implements PerformanceService{

	@Autowired
	private PerformanceRepository performanceRepository;
	
	@Override
	public List<Performance> getAllPerformance() {
		return performanceRepository.findAll();
	}

	@Override
	public Performance getPerformanceById(long id) {
		Optional<Performance> optional = performanceRepository.findById(id);
		Performance performance = null;
		if (optional.isPresent()) {
			performance = optional.get();
		} else {
			throw new RuntimeException(" Performance not found for id :: " + id);
		}
		return performance;
	}

	@Override
	public void savePerformance(Performance performance) {
		
		this.performanceRepository.save(performance);
		
	}

	@Override
	public void deletePerformanceById(long id) {
		
		this.performanceRepository.deleteById(id);
		
	}

}
