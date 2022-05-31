package com.gdm.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gdm.commons.GenericServiceImpl;
import com.gdm.entities.FichaAtributos;
import com.gdm.repository.dao.intefaces.IFichaAtributosRepository;

@Service
public class FichaAtributoServiceImpl extends GenericServiceImpl<FichaAtributos,String> {
	
	
	@Autowired
	IFichaAtributosRepository fichaAtrRep;

	
	public FichaAtributos getAtributosFichaSoja() {
		return fichaAtrRep.getAtributosFichaSoja();
	}

	@Override
	public CrudRepository<FichaAtributos, String> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
