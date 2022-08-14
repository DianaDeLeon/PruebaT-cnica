package com.example.ManejoDeEventos.repository;

import com.example.ManejoDeEventos.entidades.Localidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends CrudRepository<Localidad, Long> {
}
