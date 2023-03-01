package com.ems.service;

import java.util.List;

import com.ems.model.Performance;

public interface PerformanceService {

	List<Performance> getAllPerformance();
	Performance getPerformanceById(long id);
	void savePerformance(Performance performance);
	void deletePerformanceById(long id);
}
