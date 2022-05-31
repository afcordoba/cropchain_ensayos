package com.gdm.repository.dao.intefaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdm.entities.FichaAtributos;

public interface IFichaAtributosRepository extends JpaRepository<FichaAtributos, String>{

	@Query(value = "SELECT atr_uno,atr_dos,atr_tres,atr_cuatro,atr_cinco,atr_seis,atr_siete,atr_ocho,atr_nueve,atr_diez FROM FichaSojaAtributos;", nativeQuery=true)
	FichaAtributos getAtributosFichaSoja();

}
