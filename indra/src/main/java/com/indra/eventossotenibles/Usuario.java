package com.indra.eventossotenibles;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @author mario
 */
public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;
    private Map<String, Evento> mapEventos;

    public Usuario(String n, String c, String cont) {
        this.nombre = n;
        this.correo = c;
        this.contraseña = cont;
        this.mapEventos = new HashMap<>();
    }
    
    public void inscribirAEvento(Evento e) {
        String nombreYFecha = e.getNombre() + "_" + e.getFecha().toString();
        if (mapEventos.containsKey(nombreYFecha)) {
            throw new RuntimeException("Ya estás inscrito a este evento en esa fecha o no existe.");
        } else {
            mapEventos.put(nombreYFecha, e);
            e.getMapUsuarios().put(this.nombre, this);
        }
    }

    public void borrarDeEvento(Evento e) {
        String nombreYFecha = e.getNombre() + "_" + e.getFecha().toString();
        if (mapEventos.containsKey(nombreYFecha)) {
            mapEventos.remove(nombreYFecha);
            e.getMapUsuarios().remove(this.nombre);
        } else {
            throw new RuntimeException("No estás inscrito a ese evento en esa fecha o no existe.");
        }
    }

    public void mostrarEventos() {
        if (!mapEventos.isEmpty()) {
            for (Evento e : mapEventos.values()) {
                System.out.println(e);
            }
        } else {
            throw new RuntimeException("Este usuario no está inscrito a ningún evento o no existe.");
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        hash = 29 * hash + Objects.hashCode(this.correo);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
