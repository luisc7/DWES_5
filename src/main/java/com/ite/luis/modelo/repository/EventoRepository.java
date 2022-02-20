package com.ite.luis.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.luis.modelo.entitybeans.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	
	@Query("select e from Evento e where e.estado = ?1")
	public List<Evento> buscarActivos(String estado);
	
	@Query("select e from Evento e where e.destacado = ?1")
	public List<Evento> buscarDestacados(String destacado);
	
	/*@Query("select e from Evento e where e.nombre like = %?1% ")
	public List<Evento> buscarPorNombre(String destacado);*/

}
