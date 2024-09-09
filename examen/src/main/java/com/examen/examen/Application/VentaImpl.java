package com.examen.examen.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.examen.Domain.Entities.Bicicletas;
import com.examen.examen.Domain.Entities.Venta;
import com.examen.examen.Domain.Services.VentasServicios;
import com.examen.examen.Infraestructure.Repositorios.BicicletasRepositorio;
import com.examen.examen.Infraestructure.Repositorios.VentasRepositorio;

@Service
public class VentaImpl implements VentasServicios {


    @Autowired
    VentasRepositorio repositorio;

    @Override
    public Optional<Venta> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Venta createOne(Venta venta) {
        return repositorio.save(venta);
    }

    @Override
    public Optional<Venta> update(Long id, Venta venta) {

        Optional<Venta> ventaOpcional = repositorio.findById(id);

        if (ventaOpcional.isPresent()) {
            
            Venta ventaDB = ventaOpcional.orElseThrow();
            
            
            ventaDB.setFecha(venta.getFecha());
            ventaDB.setCliente(venta.getCliente());
           

            return Optional.of(repositorio.save(ventaDB));
            
        }
        return ventaOpcional;
    }

    @Override
    public Optional<Venta> delete(Long id) {

        Optional<Venta> ventaOpcional = repositorio.findById(id);

        ventaOpcional.ifPresent(ventaDB -> {

            repositorio.delete(ventaDB);

        });
        return ventaOpcional;
    }

}
