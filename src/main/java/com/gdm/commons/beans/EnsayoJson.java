package com.gdm.commons.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class EnsayoJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Cultivo;

	private String Pais;

	private String Campania;

	private String TipoDeREd;

	private String Epoca;

	private String CoordenadaEnsayo_1;

	private String CoordenadaEnsayo_2;
	
	private String key;
	
	private Long id;
}
