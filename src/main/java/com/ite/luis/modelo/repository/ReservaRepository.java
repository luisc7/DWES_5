package com.ite.luis.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.luis.modelo.entitybeans.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	// Trayendo lista de las reservas y calculando en programa
	@Query("select r from Reserva r where r.evento.idEvento =?1")
	public List<Reserva> reservasEnEvento(int idEvento);
	
	// Haciendo que el gestor de la BBDD sume la cantidad, que debería ser más eficiente
	@Query("select sum(r.cantidad) from Reserva r where r.evento.idEvento =?1")
	public Integer reservasTotalEvento(int idEvento);

}
