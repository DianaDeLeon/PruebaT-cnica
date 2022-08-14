package com.example.ManejoDeEventos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Table(name="Evento")
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombre;
    private String lugar;
    private Date fecha;

    private Integer status;

    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )

    @JoinColumn(name = "localidad_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Localidad localidad;

    public Evento() {
    }

    public Evento(Long id, String nombre, String lugar, Date fecha, Integer status,Localidad localidad) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.status=status;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
