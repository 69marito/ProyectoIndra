package com.indra.eventossotenibles;

import java.util.Objects;

public class Ubicacion {
    private String direccion;
    private String tipo;

    public Ubicacion(String d, String t) {
        this.direccion = d;
        this.tipo = t;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.direccion);
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
        final Ubicacion other = (Ubicacion) obj;
        return Objects.equals(this.direccion, other.direccion);
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "direccion=" + direccion + ", tipo=" + tipo + '}';
    }
    
}
