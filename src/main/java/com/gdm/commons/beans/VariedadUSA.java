package com.gdm.commons.beans;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableAutoConfiguration
@Getter @Setter
public class VariedadUSA {
	private int id;
	private String name;
	private String gid;
	private String brand;
	private String technology;
	private String instance;
	private Boolean isNew;
	private String campania;
	private Ficha ficha;
	private String linkFicha;
}
