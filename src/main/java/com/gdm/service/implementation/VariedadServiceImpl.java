package com.gdm.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gdm.commons.GenericServiceImpl;
import com.gdm.entities.Variedad;
import com.gdm.repository.dao.intefaces.IVariedadRepository;

@Service
public class VariedadServiceImpl extends GenericServiceImpl<Variedad,Integer>{

	@Autowired
	IVariedadRepository variedadRep;
	
	
	
	@Override
	public CrudRepository<Variedad, Integer> getDao() {
		
		return variedadRep;
	}
	
}
