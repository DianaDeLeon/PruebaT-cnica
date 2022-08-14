package com.example.ManejoDeEventos.controller;
import com.example.ManejoDeEventos.BadRequestException;
import com.example.ManejoDeEventos.entidades.Evento;
import com.example.ManejoDeEventos.entidades.Localidad;
import com.example.ManejoDeEventos.servicios.EventoServices;
import com.example.ManejoDeEventos.servicios.LocalidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoServices eventoServices;
    private LocalidadServices localidadServices;

    @Autowired
    public EventoController(EventoServices eventoServices, LocalidadServices localidadServices){
        this.eventoServices=eventoServices;
        this.localidadServices=localidadServices;
    }

    @GetMapping()
    public ArrayList<Evento> obtenerEventos(){
        return eventoServices.obtenerEventos();
    }

    @PostMapping
    public Evento guardarUsuario(@RequestBody Evento evento){
        evento.setStatus(1);
        return eventoServices.guardarEvento(evento);
    }


    @PutMapping("/{idEvento}/localidad/{idLocalidad}")
    public Evento asignarEventoALocalidad(@PathVariable("idEvento") Long idEvento, @PathVariable("idLocalidad") Long idlocalidad){
        Optional<Evento> oEvento= eventoServices.obtenerPorId(idEvento);
        if(!oEvento.isPresent()){
            throw new BadRequestException(String.format("El evento con el id %d no existe",idEvento));
        }
        Optional <Localidad> oLocalidad =localidadServices.buscarPorId(idlocalidad);
        if (!oLocalidad.isPresent()){
            throw new BadRequestException(String.format("La localidad con el id %d no existe",idlocalidad));
        }
        if(oEvento.get().getStatus()!=1){
            throw new BadRequestException(String.format("El evento %d no esta activo",idEvento));
        }

        Evento evento = oEvento.get();
        Localidad localidad= oLocalidad.get();
        ((Evento)evento).setLocalidad(localidad);
        return eventoServices.guardarEvento(evento);
    }

    @PutMapping("/{id}")
    public Evento actualizarEvento (@PathVariable Long id,@RequestBody Evento evento){
        Evento eventoUpdate= null;
        Optional<Evento> oEvento = eventoServices.obtenerPorId(id);
        if(!oEvento.isPresent()){
            throw new BadRequestException(String.format("El evento con el id %d no existe",id));
        }
        eventoUpdate=oEvento.get();
        eventoUpdate.setStatus(evento.getStatus());
        return eventoServices.guardarEvento(eventoUpdate);
    }

    @DeleteMapping(path="/{id}/clave/{clave}")
    public String eliminarEventoporId(@PathVariable("id")Long id , @PathVariable("clave")Integer clave){

        if (clave==676599){
            boolean ok= this.eventoServices.eliminarEvento(id);
            if (ok){
                return "Se elimino el evento "+id;
            }
            else {
                return "No se pudo eliminar el evento "+id;
            }
        }
        return  "Permiso denegado";
    }



}




