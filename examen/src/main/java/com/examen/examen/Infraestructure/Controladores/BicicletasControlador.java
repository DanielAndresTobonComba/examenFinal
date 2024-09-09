package com.examen.examen.Infraestructure.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.examen.Domain.Entities.Bicicletas;
import com.examen.examen.Domain.Services.BicicletaServicios;

@RestController
@RequestMapping("/bicicletas")

public class BicicletasControlador {

    @Autowired 
    private BicicletaServicios servicio;


    // http://localhost:8090/bicicletas/findBikeById/1


    @GetMapping("/findBikeById/{id}")
    public Optional<Bicicletas>findBikeById(@PathVariable Long id) {
        
        return servicio.findById(id);
    } 

    // http://localhost:8090/bicicletas/create
    /* 
     
        {
        "precio": 999,

        "modelo": {
            "id": 2
        },
            
            "marca": {
            "id": 2
        },
        "stock": 99
        }
     
     */

    @PostMapping("/create")
    public Bicicletas createOne(@RequestBody Bicicletas bicicletas) {
        
        return servicio.createOne(bicicletas) ;
    }


    // http://localhost:8090/bicicletas/updateBike/1
    
    /* 
     
        {
        "precio": 999,

        "modelo": {
            "id": 2
        },
            
            "marca": {
            "id": 2
        },
        "stock": 99
        }
     
     */



    @PutMapping("/updateBike/{id}") 
    public  Optional <Bicicletas> updateOne (@PathVariable Long id , @RequestBody Bicicletas bicicletas) {

        

        return servicio.update(id, bicicletas);

    }


    // http://localhost:8090/bicicletas/deleteOne/1

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Bicicletas> bicicletaOptional = servicio.delete(id);
        
        if (bicicletaOptional.isPresent()) {

            return "Bicicleta numero : " + id + " ha sido eliminada";
        }
        

        return "Bicicleta numero : " + id + " no existe ";


    }


}

