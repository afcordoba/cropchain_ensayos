package com.gdm.commons.beans;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableAutoConfiguration
@Getter @Setter
public class Catalogo {
	private int id;
	private String instancia;//LATAM,BRASIL,USA
    private List<VariedadDummy> variedades;
}
