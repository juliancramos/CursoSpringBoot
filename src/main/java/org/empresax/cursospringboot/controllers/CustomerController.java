package org.empresax.cursospringboot.controllers;

import org.empresax.cursospringboot.Modelo.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers=new ArrayList<Customer>(Arrays.asList(
            new Customer(1,"nombre1", "contra 1 "),
            new Customer(2,"nombre2", "contra 2 "),
            new Customer(3,"nombre3", "contra 3 ")
    ));

    //@GetMapping //Si no se pone el Request Mapping entonces se debe poner la ruta ("/clientes")
    @RequestMapping(method = RequestMethod.GET)//Alternativa a GetMapping si se está usando Request
    private ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
    }
    //@GetMapping("/{nombre}")
    @RequestMapping(value = "/{nombre}", method = RequestMethod.GET)//Alternativa a GetMapping con parámetro
    private ResponseEntity <?> getCustomer(@PathVariable String nombre){
        for(Customer c:customers){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con nombre: " + nombre);
    }
    @PostMapping
    public ResponseEntity <?> postCustomer(@RequestBody Customer c){
        customers.add(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente con nombre: "+ c.getNombre());
    }
    @PutMapping
    public ResponseEntity <?> putCustomer(@RequestBody Customer c){
        for(Customer c1:customers){
            if(c1.getId()==c.getId()){
                c1.setNombre(c.getNombre());
                c1.setContra(c.getContra());
                return ResponseEntity.ok("Cliente modificado exitosamente con nombre: "+ c.getNombre());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: " + c.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteCustomer(@PathVariable int id){
        for(Customer c:customers){
            if(c.getId()==id){
                customers.remove(c);
                return ResponseEntity.ok("Cliente borrado exitosamente con id: "+ c.getId());
                //Hacerlo de la siguiente manera no tira error pero es contradictoria ya que se usa un NO_CONTENT pero
                // igualmente se envía contenido, por lo tanto es mejor con un ok si se quiere enviar información
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente borrado exitosamente con id: "+ c.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: " + id);
    }
    @PatchMapping
    public ResponseEntity <?> patchCustomer(@RequestBody Customer customer){
        for(Customer c1:customers){
            if(c1.getId()==customer.getId()){
                if (customer.getNombre() != null) {
                    c1.setNombre(customer.getNombre());
                }
                if (customer.getContra() != null) {
                    c1.setContra(customer.getContra());
                }
                return ResponseEntity.ok("Cliente modificado exitosamente con id: "+ customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: " + customer.getId());
    }
}
