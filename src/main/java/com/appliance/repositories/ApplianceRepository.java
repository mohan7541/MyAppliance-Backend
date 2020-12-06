package com.appliance.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.appliance.models.Appliance;

@Repository
public interface ApplianceRepository extends PagingAndSortingRepository<Appliance, Long> {

	
	public Optional<Appliance> findByBrandAndModelIgnoreCase(String brand, String model);
}
