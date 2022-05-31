package com.gdm.commons.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter  @ToString
public class EnsayoMapa implements Serializable{
		
	private static final long serialVersionUID = 1L;

	private EnsayoJson ensayo;
    
	private FichaEnsayo fichaEnsayo;
	
	public EnsayoMapa() {
		ensayo = new EnsayoJson();
		fichaEnsayo = new FichaEnsayo(); 
		
	}
		
}
