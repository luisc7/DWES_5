package com.ite.luis.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.luis.modelo.entitybeans.Reserva;
import com.ite.luis.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImpl implements ReservaDao{
	
	@Autowired ReservaRepository rrepo;

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
	public int reservasDeUnEvento(int idEvento) {
		return rrepo.reservasTotalEvento(idEvento);
	}

}
