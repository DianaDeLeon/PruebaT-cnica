package com.example.ManejoDeEventos.servicios;

import com.example.ManejoDeEventos.entidades.Evento;
import com.example.ManejoDeEventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EventoServices {

    @Autowired
    EventoRepository eventoRepository;

    public ArrayList<Evento> obtenerEventos(){
        return (ArrayList<Evento>) eventoRepository.findAll();
    }

    public Optional<Evento> obtenerPorId(Long id){
        return eventoRepository.findById(id);
    }
    public Evento guardarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    public boolean eliminarEvento(Long id) {
        try {
            eventoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
