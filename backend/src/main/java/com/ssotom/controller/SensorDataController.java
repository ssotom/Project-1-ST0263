package com.ssotom.controller;

import java.util.LinkedList;
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
import com.ssotom.response.DataSerie;
import com.ssotom.response.Serie;

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
	
	@GetMapping()
	@RequestMapping("/series")
	public List<Serie> series() {
		List<SensorData> data = sensorDataRepository.findAll();
		List<Serie> series = new LinkedList<Serie>();
		Serie temperature = new Serie("temperature");
		Serie humidity = new Serie("humidity");
		
		for(SensorData d: data) {
			temperature.add(new DataSerie(d.getTemperature(), d.getCreatedAt().toString()));
			humidity.add(new DataSerie(d.getHumidity(), d.getCreatedAt().toString()));
		}
		
		series.add(temperature);
		series.add(humidity);
		return series;
	}
	
	@PostMapping()
	public SensorData save(@Valid @RequestBody SensorData sensorData) {
		return sensorDataRepository.save(sensorData);
	}

}
