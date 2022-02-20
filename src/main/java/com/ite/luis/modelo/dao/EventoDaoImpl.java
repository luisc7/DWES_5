package com.ite.luis.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.luis.modelo.entitybeans.Evento;
import com.ite.luis.modelo.repository.EventoRepository;

@Repository
public class EventoDaoImpl implements EventoDao{
	
	@Autowired
	private EventoRepository erepo;

	@Override
	public List<Evento> findActive() {
		return erepo.buscarActivos("Activo");
	}

	@Override
	public List<Evento> findHighlights() {
		return erepo.buscarDestacados("s");
	}

	/*@Override
	public List<Evento> searchName(String nombre) {
		return erepo.buscarPorNombre(nombre);
	}*/

	@Override
	public int plazasLibres(int idEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Evento verEvento(int idEvento) {
		return erepo.findById(idEvento).orElse(null);
	}

	@Override
	public boolean newEvento(Evento evento) {
		boolean alta = false;
		if (verEvento(evento.getIdEvento()) == null) {
			try {
				erepo.save(evento);
				alta = true;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return alta;
	}

	@Override
	public boolean modEvento(Evento evento) {
		boolean modificado = false;
		if (verEvento(evento.getIdEvento()) != null) {
			try {
				erepo.save(evento);
				modificado = true;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return modificado;
	}

	@Override
	public boolean delEvento(int idEvento) {
		boolean eliminacion = false;
		if (verEvento(idEvento) != null) {
			try {
				erepo.deleteById(idEvento);;
				eliminacion = true;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return eliminacion;
	}

}
