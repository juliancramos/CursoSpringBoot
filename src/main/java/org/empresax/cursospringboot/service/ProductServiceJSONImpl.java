package org.empresax.cursospringboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.empresax.cursospringboot.Modelo.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
}
