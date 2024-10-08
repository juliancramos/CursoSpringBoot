package org.empresax.cursospringboot.controllers;

import org.empresax.cursospringboot.Modelo.Product;
import org.empresax.cursospringboot.service.ProductService;
import org.empresax.cursospringboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //No es necesario si se usa inyección de dependencias
    //ProductService productsService = new ProductServiceImpl(); //Polimorfismo dinámico

    @Autowired
    @Qualifier ("jsonResourceQualifier")
    private ProductService productsService; //Inyección de dependencias


    @GetMapping
    public ResponseEntity <?> getProducts() {
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> getProduct(@PathVariable Integer id) {
        try{
            Product product = productsService.getProduct(id);
            return ResponseEntity.ok(product);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


}
