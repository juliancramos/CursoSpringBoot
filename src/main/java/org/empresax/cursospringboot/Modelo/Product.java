package org.empresax.cursospringboot.Modelo;

public class Product {
    private Integer id;
    private String nome;
    private Double price;
    private Integer stock;
    //Se usa Integer y Double para permitir valores nulos


    public Product(Integer id, String nome, Double price, Integer stock) {
        this.id = id;
        this.nome = nome;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
