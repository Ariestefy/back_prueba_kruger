package com.CRUD.prueba.controlador;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.prueba.excepcion.noexcepcion;
import com.CRUD.prueba.modelo.ACTIVIDAD;
import com.CRUD.prueba.repositorio.actividadrepositorio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class actividadcontrolador {

	@Autowired
	private actividadrepositorio actividadrepositorio;
	

	@GetMapping("/actividad")
	public List<ACTIVIDAD> getAllactividad(){
		return actividadrepositorio.findAll();
	}		
	

	@PostMapping("/actividad")
	public ACTIVIDAD createACTIVIDAD(@RequestBody ACTIVIDAD ACTIVIDAD) {
		return actividadrepositorio.save(ACTIVIDAD);
	}
	
	
	@GetMapping("/actividad/{id}")
	public ResponseEntity<ACTIVIDAD> getACTIVIDADById(@PathVariable Long id) {
		ACTIVIDAD ACTIVIDAD = actividadrepositorio.findById(id)
				.orElseThrow(() -> new noexcepcion("No existe" + id));
		return ResponseEntity.ok(ACTIVIDAD);
	}
	
	
	@PutMapping("/actividad/{id}")
	public ResponseEntity<ACTIVIDAD> updateACTIVIDAD(@PathVariable Long id, @RequestBody ACTIVIDAD ACTIVIDADDetails){
		ACTIVIDAD ACTIVIDAD = actividadrepositorio.findById(id)
				.orElseThrow(() -> new noexcepcion("No existe" + id));
		
		ACTIVIDAD.setnombre(ACTIVIDADDetails.getnombre());
		ACTIVIDAD.setdescripcion(ACTIVIDADDetails.getdescripcion());
		ACTIVIDAD.setfechaInicio(ACTIVIDADDetails.getfechaInicio());
		ACTIVIDAD.setfechaFin(ACTIVIDADDetails.getfechaFin());
		ACTIVIDAD.settiempoEstimado(ACTIVIDADDetails.gettiempoEstimado());
		ACTIVIDAD.setarchivo(ACTIVIDADDetails.getarchivo());
		ACTIVIDAD.setrecurso(ACTIVIDADDetails.getrecurso());
		
		ACTIVIDAD updatedACTIVIDAD = actividadrepositorio.save(ACTIVIDAD);
		return ResponseEntity.ok(updatedACTIVIDAD);
	}
	

	@DeleteMapping("/actividad/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteACTIVIDAD(@PathVariable Long id){
		ACTIVIDAD ACTIVIDAD = actividadrepositorio.findById(id)
				.orElseThrow(() -> new noexcepcion("No existe" + id));
		
		actividadrepositorio.delete(ACTIVIDAD);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
