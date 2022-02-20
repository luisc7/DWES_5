package com.ite.luis.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.luis.modelo.dao.EventoDao;
import com.ite.luis.modelo.dao.ReservaDao;
import com.ite.luis.modelo.entitybeans.Evento;
import com.ite.luis.modelo.entitybeans.Info;

@RestController
@RequestMapping("/rest/eventos")
public class EventoRestController {
	
	@Autowired EventoDao edao;
	@Autowired ReservaDao rdao;
	
	@GetMapping("/activos")
	public List<Evento> verActivos(){
		return edao.findActive();
	}
	
	@GetMapping("/destacados")
	public List<Evento> verDestacados(){
		return edao.findHighlights();
	}
	
	@GetMapping("/buscarEventos/{subcadena}")
	public List<Evento> verNombre(@PathVariable("subcadena") String subcadena){
		return edao.searchName(subcadena);
	}
	
	@GetMapping("/buscarEventosDescripcion/{subcadena}")
	public List<Evento> verDescrip(@PathVariable("subcadena") String subcadena){
		return edao.searchDescrip(subcadena);
	}
	
	/*@GetMapping("/plazasQuedan/{idEvento}")
	public String plazasLibres(@PathVariable("idEvento") int idEvento){
		//return "{\"quedan_plazas\" : " + (edao.plazasTotales(idEvento) - rdao.reservasDeEvento(idEvento)) + '}';
		return "{\"quedan_plazas\" : " + (edao.plazasTotales(idEvento) - rdao.reservasDeUnEvento(idEvento)) + '}';
	}*/
	
	@GetMapping("/plazasQuedan/{idEvento}")
	public Info plazasLibres(@PathVariable("idEvento") int idEvento){
		Info i = new Info();
		i.setQuedan_plazas((edao.plazasTotales(idEvento) - rdao.reservasDeUnEvento(idEvento)));
		return i;
	}
	
	
	@GetMapping("/verUno/{idEvento}")
	public Evento verEvento(@PathVariable("idEvento") int idEvento){
		return edao.verEvento(idEvento);
	}
	
	@PostMapping("/alta")
	public String nuevoEvento(@RequestBody Evento evento){
		/*if (edao.altaEvento(evento)) {
			return "Evento " + evento.getDescripcion() + " dado de alta";
		} else {
			return "No se ha podido dar de alta el evento";
		}*/
		return (edao.newEvento(evento))? 
				"Evento " + evento.getDescripcion() + " dado de alta"
				:"No se ha podido dar de alta el evento";
	}
	
	@PutMapping("/modificar")
	public String modificarEvento(@RequestBody Evento evento){
		return (edao.modEvento(evento))? 
				"Evento " + evento.getDescripcion() + " modificado"
				:"No se ha podido modificar el evento";
	}
	
	@DeleteMapping("/eliminar/{idEvento}")
	public String eliminarEvento(@PathVariable("idEvento") int idEvento){
		return (edao.delEvento(idEvento))? 
				"Evento " + idEvento + " eliminado"
				:"No se ha podido eliminar el evento";
	}
	

}
