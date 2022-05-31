package com.gdm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gdm.commons.GenericServiceImpl;
import com.gdm.entities.Ensayo;
import com.gdm.repository.dao.intefaces.IEnsayoRepository;

@Service
public class EnsayoServiceImpl extends GenericServiceImpl<Ensayo,Integer>{

	
	@Autowired
	IEnsayoRepository repo;
	
	@Override
	public CrudRepository<Ensayo, Integer> getDao() {
		return repo;
	}
public List<Ensayo> findbyAllParameters(String red) {
		
		return repo.findbyAllParams(red);
	}

}
