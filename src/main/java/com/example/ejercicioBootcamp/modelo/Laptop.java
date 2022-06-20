package com.example.ejercicioBootcamp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String anio;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String anio) {
        this.id = id;
        this.marca = marca;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", anio='" + anio + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
