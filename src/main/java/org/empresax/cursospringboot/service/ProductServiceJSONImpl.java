package org.empresax.cursospringboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.empresax.cursospringboot.Modelo.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Service("jsonResourceQualifier")
public class ProductServiceJSONImpl implements ProductService{

    @Override
    public List<Product> getProducts() {
        List <Product> products;
        try{
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>(){});
            return products;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProduct(Integer id) {
        return getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con id: " + id));
    }
}
