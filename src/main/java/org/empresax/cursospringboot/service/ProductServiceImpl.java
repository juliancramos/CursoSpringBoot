package org.empresax.cursospringboot.service;

import org.empresax.cursospringboot.Modelo.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 899.99, 10 ),
            new Product(2, "Smartphone", 699.99, 25 ),
            new Product(3, "Tablet", 399.99, 15 ),
            new Product(4, "Smartwatch", 899.99, 30 )
    ));

    public List<Product> getProducts() {
        return products;
    }
}
