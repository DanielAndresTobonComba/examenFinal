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


import com.examen.examen.Domain.Entities.Detalles_ventas;
import com.examen.examen.Domain.Services.DetallesVentasServicios;

@RestController
@RequestMapping("/detalles_ventas")
public class DetallesVentasControlador {

    @Autowired 
    private DetallesVentasServicios servicio;

    // http://localhost:8090/detalles_ventas/findDetalleVentaById/1

    @GetMapping("/findDetalleVentaById/{id}")
    public Optional<Detalles_ventas>findDetalleVentaById(@PathVariable Long id) {
        
        return servicio.findById(id);
    } 


    // http://localhost:8090/detalles_ventas/create

    /* 
     {
  "id": 2,
  "cantidad": "105",
  "precioUnitario": "99.99",
  "venta": {
    "id": 1

  },
  "bicicletas": {
    "id": 1

  }
}
     */

    @PostMapping("/create")
    public Detalles_ventas createOne(@RequestBody Detalles_ventas detalles_ventas) {
        
        return servicio.createOne(detalles_ventas) ;
    }


      // http://localhost:8090/detalles_ventas/updateDetalles/1

      /* 
       {
  "cantidad": "105",
  "precioUnitario": "99.99",
  "venta": {
    "id": 1

  },
  "bicicletas": {
    "id": 1

  }
} 
       
       */

    @PutMapping("/updateDetalles/{id}") 
    public  Optional <Detalles_ventas> updateOne (@PathVariable Long id , @RequestBody Detalles_ventas detalles_ventas) {

        

        return servicio.update(id, detalles_ventas);

    }

    // http://localhost:8090/detalles_ventas/deleteOne/1

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Detalles_ventas> detallesOpcional = servicio.delete(id);
        
        if (detallesOpcional.isPresent()) {

            return "Detalle de venta numero : " + id + " ha sido eliminada";
        }
        

        return "Detalle de venta numero : " + id + " no existe ";


    }

}
