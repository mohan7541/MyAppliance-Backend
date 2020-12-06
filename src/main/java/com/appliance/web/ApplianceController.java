package com.appliance.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appliance.exception.GlobalException;
import com.appliance.models.Appliance;
import com.appliance.service.ApplianceService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appliance")
public class ApplianceController {

	@Autowired
	private ApplianceService applianceService;
	
	@PostMapping
	public Appliance createAppliance(@RequestBody Appliance appliance) throws GlobalException {
		return applianceService.createAppliance(appliance);
	}
	
	@GetMapping
	public List<Appliance> getAllAppliances(@RequestParam Map<String, String> params) {
		System.out.println("getAllAppliances");
		return applianceService.getAllAppliances(params);
	}
	
	@GetMapping(path = "/{serialNumber}", produces = {"application/json"})
	public Appliance getApplianceById(@PathVariable("serialNumber") Long serialNumber) {
		return applianceService.findById(serialNumber);
	}
	
	@PutMapping
	public Appliance updateAppliance(@RequestBody Appliance appliance) {
		return applianceService.updateAppliance(appliance);
	}
	
	@DeleteMapping(path = "/{serialNumber}")
	public void deleteAppliance(@PathVariable("serialNumber") Long serialNumber) {
		applianceService.deleteAppliance(serialNumber);
	}
   
}
