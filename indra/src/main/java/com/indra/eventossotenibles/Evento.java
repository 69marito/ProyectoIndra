package com.indra.eventossotenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @author mario
 */

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private int duracion;
    private String ubicacion;
    private String tipo;
    private String organizador;
    private Map <String, Usuario> mapUsuarios = new HashMap<>();

    public Evento(String nombre, LocalDate fecha, int duracion, String ubicacion, String tipo, String organizador) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.organizador = organizador;
    }
    
    public void mostrarParticipantes() {
        if (!mapUsuarios.isEmpty()) {
            for (Usuario u : mapUsuarios.values()) {
                System.out.println(u);
            }
        } else {
            throw new RuntimeException("Mapa de usuarios vacía o proyecto inexistente");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public Map<String, Usuario> getMapUsuarios() {
        return mapUsuarios;
    }

    public void setMapUsuarios(Map<String, Usuario> participantes) {
        this.mapUsuarios = participantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Evento{" + "nombre=" + nombre + ", fecha=" + fecha + ", duracion=" + duracion + ", ubicacion=" + ubicacion + ", tipo=" + tipo + ", organizador=" + organizador + '}';
    }
    
    
}
