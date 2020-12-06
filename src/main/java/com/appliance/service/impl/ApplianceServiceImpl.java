package com.appliance.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appliance.exception.GlobalException;
import com.appliance.models.Appliance;
import com.appliance.repositories.ApplianceRepoCustomImpl;
import com.appliance.repositories.ApplianceRepository;
import com.appliance.service.ApplianceService;

@Service
public class ApplianceServiceImpl implements ApplianceService {

	@Autowired
	private ApplianceRepository applianceRepo;
	
	@Autowired
	private ApplianceRepoCustomImpl applianceRepoCustomImpl;
	@Override
	public List<Appliance> getAllAppliances(Map<String, String> params) {
		return applianceRepoCustomImpl.findAppliances(params);
	}

	@Override
	public Appliance findById(Long serialNumber) {
		Optional<Appliance> applOpt = applianceRepo.findById(serialNumber);
		if(applOpt.isPresent())
			return applOpt.get();
		else
			return null;
	}

	@Override
	public Appliance createAppliance(Appliance appliance) throws GlobalException {
		if (appliance.getDateBought() == null) {
			appliance.setDateBought(new Date(System.currentTimeMillis()));
		}
		Optional<Appliance> existAppOpt = applianceRepo.findByBrandAndModelIgnoreCase(appliance.getBrand(), appliance.getModel());
		if(existAppOpt.isPresent()) {
			throw new GlobalException("Appliance already exists", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return applianceRepo.save(appliance);
	}

	@Override
	public Appliance updateAppliance(Appliance appliance) {
		return applianceRepo.save(appliance);
	}

	@Override
	public void deleteAppliance(Long serialNumber) {
		Appliance appliance = this.findById(serialNumber);
		if (appliance != null) {
			applianceRepo.delete(appliance);
		}
		
	}

}
