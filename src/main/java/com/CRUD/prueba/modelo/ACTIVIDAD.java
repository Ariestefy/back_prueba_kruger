package com.CRUD.prueba.modelo;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad")

public class ACTIVIDAD {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

	@Column(name = "fecha_fin")
	private LocalDate fechaFin;

	@Column(name = "tiempo_estimado")
	private Integer tiempoEstimado;

	@Column(name = "archivo")
	private String archivo;

	@ManyToOne
	@JoinColumn(name = "recurso_id")
	private RECURSO recurso;
	
	public ACTIVIDAD() {
		
	}
	
	public ACTIVIDAD(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,Integer tiempoEstimado, String archivo, RECURSO recurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiempoEstimado = tiempoEstimado;
		this.archivo = archivo;
		this.recurso = recurso;
		
		 
	}
	
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getdescripcion() {
		return descripcion;
	}
	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getfechaInicio() {
		return fechaInicio;
	}
	public void setfechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getfechaFin() {
		return fechaInicio;
	}
	public void setfechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Integer gettiempoEstimado() {
		return tiempoEstimado;
	}
	public void settiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public String getarchivo() {
		return archivo;
	}
	public void setarchivo(String archivo) {
		this.archivo = archivo;
	}
	public RECURSO getrecurso() {
		return recurso;
	}
	public void setrecurso(RECURSO recurso) {
		this.recurso = recurso;
	}
	
}
