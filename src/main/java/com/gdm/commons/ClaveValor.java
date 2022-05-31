package com.gdm.commons;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClaveValor<K,V> {
	private K clave;
	private V valor;
	private String keyValue;
	
	
	public ClaveValor(K k, V v) {
	clave = k; valor = v;
	keyValue += clave+ "," +valor+","+"\\n";
	}
	
	public void concatenar(String c, String v) {
		
		keyValue += c+ "," +v+","+"\\n";
	}
	
	 @Override
	  public String toString() {
	    return clave+ "," +valor;
	  }
}
