package com.ite.luis.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.luis.modelo.entitybeans.Reserva;
import com.ite.luis.modelo.repository.EventoRepository;
import com.ite.luis.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImpl implements ReservaDao{
	
	@Autowired ReservaRepository rrepo;
	@Autowired EventoRepository erepo;

	@Override
	public int reservasDeEvento(int idEvento) {
		int total = 0;
		List<Reserva> reservas = rrepo.reservasEnEvento(idEvento);
		for (Reserva reservaInd : reservas) {
			total += reservaInd.getCantidad();
		}
		return total;
	}

	@Override
	public Integer reservasDeUnEvento(int idEvento) {/*
	Numero positivo: Hay reservas
	0: No hay reservas, pero existe el evento (es nula la query a reservas)
	null: No existe el evento
	*/
		
		if (erepo.findById(idEvento).orElse(null) == null)
			return null;
		else {
			Integer reservas = rrepo.reservasTotalEvento(idEvento);
			return (reservas == null)? 0 : reservas;
		}
	}

}
