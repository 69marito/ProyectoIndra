package com.indra.eventossotenibles;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @author mario
 */
public class Organizador {
    private String nombre;
    private String correo;
    private long telefono;
    private Map<String, Evento> mapEventos;

    public Organizador(String n, String c, Long t) {
        this.nombre = n;
        this.correo = c;
        this.telefono = t;
        this.mapEventos = new HashMap<>();
    }
    
    public void crearEvento(Evento e) {
        if (!mapEventos.containsKey(e.getNombre())) {
            mapEventos.put(e.getNombre(), e);
        } else {
            throw new RuntimeException("Este evento ya existe");
        }
    }

    public void eliminarEvento(Evento e) {
        if (mapEventos.containsKey(e.getNombre())) {
            mapEventos.remove(e.getNombre());
        } else {
            throw new RuntimeException("Este evento no existe");
        }
    }

    public void mostrarEventos() {
        if (!mapEventos.isEmpty()) {
            for (Evento e : mapEventos.values()) {
                System.out.println(e);
            }
        } else {
            throw new RuntimeException("Este organizador no tiene ningun evento");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Map<String, Evento> getMapEventos() {
        return mapEventos;
    }

    public void setMapEventos(Map<String, Evento> mapEventos) {
        this.mapEventos = mapEventos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.correo);
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
        final Organizador other = (Organizador) obj;
        return Objects.equals(this.correo, other.correo);
    }
    
    
}
