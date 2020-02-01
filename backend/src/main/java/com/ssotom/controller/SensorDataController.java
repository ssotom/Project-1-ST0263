package com.ssotom.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssotom.model.RoleName;
import com.ssotom.model.SensorData;
import com.ssotom.model.User;
import com.ssotom.repository.SensorDataRepository;
import com.ssotom.repository.UserRepository;
import com.ssotom.response.DataSerie;
import com.ssotom.response.Sensor;
import com.ssotom.response.Serie;

@CrossOrigin()
@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {
	
	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/data")
	public List<SensorData> index() {
		return sensorDataRepository.findAll();
	}
	
	@GetMapping()
	@RequestMapping("/data/series")
	public List<Serie> series() {
		List<SensorData> data = sensorDataRepository.findAll();
		List<Serie> series = new LinkedList<Serie>();
		Serie temperature = new Serie("temperature");
		Serie humidity = new Serie("humidity");
		
		for(SensorData d: data) {
			String date = d.getCreatedAt().toString();
			temperature.add(new DataSerie(d.getTemperature(), date));
			humidity.add(new DataSerie(d.getHumidity(), date));
		}
		
		series.add(temperature);
		series.add(humidity);
		
		return series;
	}
	
	@PreAuthorize("hasRole('SENSOR')")
	@PostMapping("/data")
	@ResponseStatus(HttpStatus.CREATED)
	public SensorData save(@Valid @RequestBody SensorData sensorData) {
		sensorData.setSensor(SecurityContextHolder.getContext().getAuthentication().getName());
		return sensorDataRepository.save(sensorData);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public List<Sensor> getSensor() {
		List<User> users = userRepository.findByRole(RoleName.ROLE_SENSOR);
		List<Sensor> sensors = new LinkedList<Sensor>();
		users.forEach(user -> sensors.add(new Sensor(user)));
		return sensors;
	}

}
