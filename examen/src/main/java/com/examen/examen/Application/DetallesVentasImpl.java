package com.examen.examen.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.examen.Domain.Entities.Detalles_ventas;
import com.examen.examen.Domain.Services.DetallesVentasServicios;
import com.examen.examen.Infraestructure.Repositorios.DetallesVentasRepositorio;

@Service
public class DetallesVentasImpl implements DetallesVentasServicios {

    @Autowired
    DetallesVentasRepositorio repositorio;

    @Override
    public Optional<Detalles_ventas> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Detalles_ventas createOne(Detalles_ventas detalles_ventas) {
        return repositorio.save(detalles_ventas);
    }

    @Override
    public Optional<Detalles_ventas> update(Long id, Detalles_ventas detalles_ventas) {

        Optional<Detalles_ventas> DetalleOpcional = repositorio.findById(id);

        if (DetalleOpcional.isPresent()) {
            
            Detalles_ventas detalleDb = DetalleOpcional.orElseThrow();
            
            
            detalleDb.setCantidad(detalles_ventas.getCantidad());
            detalleDb.setPrecioUnitario(detalles_ventas.getPrecioUnitario());
            detalleDb.setBicicletas(detalles_ventas.getBicicletas());
            detalleDb.setVenta(detalles_ventas.getVenta());

            return Optional.of(repositorio.save(detalleDb));
            
        }
        return DetalleOpcional;
    }

    @Override
    public Optional<Detalles_ventas> delete(Long id) {

        Optional<Detalles_ventas> DetalleOpcional = repositorio.findById(id);

        DetalleOpcional.ifPresent(ventasDB -> {

            repositorio.delete(ventasDB);

        });
        return DetalleOpcional;
    }

}
