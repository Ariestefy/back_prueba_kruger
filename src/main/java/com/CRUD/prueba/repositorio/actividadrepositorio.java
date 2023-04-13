package com.CRUD.prueba.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.prueba.modelo.ACTIVIDAD;

@Repository

public interface actividadrepositorio extends JpaRepository<ACTIVIDAD, Long> {

}
