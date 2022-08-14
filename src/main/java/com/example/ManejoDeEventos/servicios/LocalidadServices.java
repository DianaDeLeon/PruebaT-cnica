package com.example.ManejoDeEventos.servicios;

import com.example.ManejoDeEventos.entidades.Evento;
import com.example.ManejoDeEventos.entidades.Localidad;
import com.example.ManejoDeEventos.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LocalidadServices {

    @Autowired
    LocalidadRepository localidadRepository;

    public ArrayList<Localidad> obtenerLocalidad(){
        return (ArrayList<Localidad>)localidadRepository.findAll();
    }

    public Optional<Localidad> buscarPorId(Long id){
        return localidadRepository.findById(id);
    }

    public Localidad guardarLocalidad(Localidad localidad){
        return localidadRepository.save(localidad);
    }


}
