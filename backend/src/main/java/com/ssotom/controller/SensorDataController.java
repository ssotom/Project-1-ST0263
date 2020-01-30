package com.ssotom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssotom.model.SensorData;
import com.ssotom.repository.SensorDataRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/sensors/data")
public class SensorDataController {
	
	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	@GetMapping()
	public List<SensorData> index() {
		return sensorDataRepository.findAll();
	}
	
	@PostMapping()
	public SensorData save(@Valid @RequestBody SensorData sensorData) {
		return sensorDataRepository.save(sensorData);
	}

}
