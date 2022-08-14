package com.example.ManejoDeEventos.repository;

import com.example.ManejoDeEventos.entidades.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {

}
