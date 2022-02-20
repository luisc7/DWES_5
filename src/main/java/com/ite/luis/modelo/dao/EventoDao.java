package com.ite.luis.modelo.dao;

import java.util.List;

import com.ite.luis.modelo.entitybeans.Evento;

public interface EventoDao {

	List<Evento> findActive();
	List<Evento> findHighlights();
	List<Evento> searchName(String nombre);
	List<Evento> searchDescrip(String nombre);
	Integer plazasTotales(int idEvento);
	Evento verEvento(int idEvento);
	boolean newEvento(Evento evento);
	boolean modEvento(Evento evento);
	boolean delEvento(int idEvento);
	
	
}
