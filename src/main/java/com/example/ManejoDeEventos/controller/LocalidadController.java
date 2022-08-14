package com.example.ManejoDeEventos.controller;


import com.example.ManejoDeEventos.entidades.Localidad;
import com.example.ManejoDeEventos.servicios.LocalidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/localidades")
public class LocalidadController {

    @Autowired
    LocalidadServices localidadServices;

    @GetMapping()
    public ArrayList<Localidad> obtenerLocalidad(){
        return localidadServices.obtenerLocalidad();
    }

    @PostMapping()
    public  Localidad guardarLocalidad(@RequestBody Localidad localidad){
        return this.localidadServices.guardarLocalidad(localidad);
    }


}
