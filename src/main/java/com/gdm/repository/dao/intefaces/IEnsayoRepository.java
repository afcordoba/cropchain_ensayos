package com.gdm.repository.dao.intefaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gdm.entities.Ensayo;

@Repository
public interface IEnsayoRepository extends CrudRepository<Ensayo, Integer> {
	
	@Query(value = "select ID, Cultivo,Pais,tipode_red,red_zonal,Localidad,micro_region,Campania,firma,fecha_siembra,Antecesor,promedio_ensayo,\n" + 
			"macro_region,Epoca,coordenada_ensayo_1,coordenada_ensayo_2,Genotipo,Rendimiento,ensayo FROM manejo.mapa_ensayos WHERE tipode_red = :red order by ensayo, Rendimiento desc", nativeQuery=true)
	List<Ensayo> findbyAllParams(@Param("red") String red) ;
	

}
