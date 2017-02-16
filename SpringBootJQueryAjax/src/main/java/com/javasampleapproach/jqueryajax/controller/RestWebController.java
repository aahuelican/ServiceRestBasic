package com.javasampleapproach.jqueryajax.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.model.Customer;
 
@RestController
public class RestWebController {
 
    List<Customer> cust = new ArrayList<Customer>();
 
    @RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
    public Response getResource() {
        Response response = new Response("Done", cust);
        return response;
    }
 
    @RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
    public Response postCustomer(@RequestBody Customer customer) {
        cust.add(customer);
        Response response = new Response("Done", customer);
        return response;
    }
    
    //actualizamos todo el objeto 
    @RequestMapping(value = "/putcustomer/{nombre}", method = RequestMethod.PUT)
    public Response putCustomer(@PathVariable("nombre") String nombre,@RequestBody Customer customer) {
    	boolean bandera = false;
    	String  msj     = ""; 
    	
    	/*Mandamos allamar al servicio (Pendiente)*/
    	for(int i = 0; i< cust.size();i++){
          Customer c =(Customer)cust.get(i);
          if(c.getFirstname()!=null && c.getFirstname().equals(nombre)){
        	   cust.remove(i);
        	   cust.add(i,customer);
        	   bandera = true;
          }
        }
    	
        Response response = new Response((bandera)?"Done":"notFound", customer);
        return response;
    }
    //busca y actualiza solo los registros solicitados
    @RequestMapping(value = "/patchcustomer/{nombre}", method = RequestMethod.PATCH)
    public Response patchCustomer(@PathVariable("nombre") String nombre,@RequestBody Customer customer) {
    	boolean  bandera = false;
    	Customer c      = null; 
    	/*Mandamos allamar al servicio (Pendiente)*/
    	for(int i = 0; i< cust.size();i++){
          c =(Customer)cust.get(i);
          if(c.getFirstname()!=null && c.getFirstname().equals(nombre)){
        	  if(customer.getFirstname()!=null)
        		  c.setFirstname(nombre);
        	  if(customer.getLastname()!=null)
        		  c.setLastname(customer.getLastname());
        	   if(customer.getTrabajo()!=null)
        		  c.setTrabajo(customer.getTrabajo());
        	   cust.remove(i);
        	   cust.add(i,c);
        	   bandera = true;
          }
        }
        Response response = new Response((bandera)?"Done":"notFound",c);
        return response;
    }
    
    @RequestMapping(value = "/deletecustomer/{nombre}", method = RequestMethod.DELETE)
    public Response deleteCustomer(@PathVariable String nombre) {
    	boolean  bandera = false;
    	Customer c      = null; 
    	/*Mandamos allamar al servicio (Pendiente)*/
    	for(int i = 0; i< cust.size();i++){
          c =(Customer)cust.get(i);
          if(c.getFirstname()!=null && c.getFirstname().equals(nombre)){
        	   cust.remove(i);
        	   bandera = true;
        	   i       = cust.size();
          }
        }
        Response response = new Response((bandera)?"Done":"notFound",c);
        return response;
    }
}