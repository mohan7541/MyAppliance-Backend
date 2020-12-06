package com.appliance.repositories;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appliance.models.Appliance;

@Repository
public class ApplianceRepoCustomImpl {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Appliance> findAppliances(Map<String, String> params){
		
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("select a from Appliance a where 1=1");
		if(params.containsKey("brand")) {
			queryBuilder.append(" AND UPPER(a.brand) like UPPER(:brand) ");
		}
		if(params.containsKey("status")) {
			queryBuilder.append(" AND UPPER(a.status) like UPPER(:status) ");
		}
		if(params.containsKey("model")) {
			queryBuilder.append(" AND UPPER(a.model) like UPPER(:model) ");
		}
		TypedQuery<Appliance> query = entityManager.createQuery(queryBuilder.toString(), Appliance.class);
		Set<String> keys = params.keySet();
		for(String key : keys) {
			query.setParameter(key, "%" + params.get(key) + "%");
		}
		
		return query.getResultList();
	}
}
