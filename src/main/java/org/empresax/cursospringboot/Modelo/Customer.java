package org.empresax.cursospringboot.Modelo;

public class Customer {
    private int id;
    private String nombre;
    private String contra;

    public Customer(int id, String nombre, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nome) {
        this.nombre = nome;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
