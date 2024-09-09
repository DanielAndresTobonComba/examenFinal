package com.examen.examen.Infraestructure.Controladores;

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
import com.examen.examen.Domain.Entities.Venta;
import com.examen.examen.Domain.Services.BicicletaServicios;
import com.examen.examen.Domain.Services.VentasServicios;

@RestController
@RequestMapping("/ventas")
public class VentasControlador {


    @Autowired 
    private VentasServicios servicio;


    // http://localhost:8090/ventas/findVentaById/1

    @GetMapping("/findVentaById/{id}")
    public Optional<Venta>findVentaById(@PathVariable Long id) {
        
        return servicio.findById(id);
    } 

    // http://localhost:8090/ventas/createOne
    /* 
     
        

{

  "fecha": "2024-09-09",
  "cliente": {
    "id": 1
 
  }
}

     
     */

    @PostMapping("/createOne")
    public Venta createOne(@RequestBody Venta venta) {
        
        return servicio.createOne(venta) ;
    }


    // http://localhost:8090/ventas/updateVenta/1
    
    /* 
     
        {
        
        "fecha": "2104-09-12",
            "cliente": {
            "id": 1
        
        }

        }
     
     */



    @PutMapping("/updateVenta/{id}") 
    public  Optional <Venta> updateOne (@PathVariable Long id , @RequestBody Venta venta) {

        

        return servicio.update(id, venta);

    }


    // http://localhost:8090/ventas/deleteOne/1

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Venta> ventaOptional = servicio.delete(id);
        
        if (ventaOptional.isPresent()) {

            return "Venta numero : " + id + " ha sido eliminada";
        }
        

        return "Venta numero : " + id + " no existe ";


    }

}
