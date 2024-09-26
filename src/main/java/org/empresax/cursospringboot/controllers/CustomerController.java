package org.empresax.cursospringboot.controllers;

import org.empresax.cursospringboot.Modelo.Customer;
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
    private List<Customer> getCustomers(){
        return customers;
    }
    //@GetMapping("/{nombre}")
    @RequestMapping(value = "/{nombre}", method = RequestMethod.GET)//Alternativa a GetMapping con parámetro
    private Customer getCustomer(@PathVariable String nombre){
        for(Customer c:customers){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }
    @PostMapping
    public Customer postCustomer(@RequestBody Customer c){
        customers.add(c);
        return c;
    }
    @PutMapping
    public Customer putCustomer(@RequestBody Customer c){
        for(Customer c1:customers){
            if(c1.getId()==c.getId()){
                c1.setNombre(c.getNombre());
                c1.setContra(c.getContra());
                return c1;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        for(Customer c:customers){
            if(c.getId()==id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }
    @PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer){
        for(Customer c1:customers){
            if(c1.getId()==customer.getId()){
                if (customer.getNombre() != null) {
                    c1.setNombre(customer.getNombre());
                }
                if (customer.getContra() != null) {
                    c1.setContra(customer.getContra());
                }
                return c1;
            }
        }
        return null;
    }
}
