package com.appliance.service;

import java.util.List;
import java.util.Map;

import com.appliance.exception.GlobalException;
import com.appliance.models.Appliance;

public interface ApplianceService {

	public List<Appliance> getAllAppliances(Map<String, String> params);
	
	public Appliance findById(Long serialNumber);
	
	public Appliance createAppliance(Appliance appliance) throws GlobalException;

	public Appliance updateAppliance(Appliance appliance);
	
	public void deleteAppliance(Long serialNumber);
}
