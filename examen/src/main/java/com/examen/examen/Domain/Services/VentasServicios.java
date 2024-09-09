package com.examen.examen.Domain.Services;

import java.util.Optional;

import com.examen.examen.Domain.Entities.Venta;

public interface VentasServicios {


    Optional <Venta> findById(Long id); 

    Venta createOne (Venta venta);

    Optional<Venta> update(Long id, Venta venta);

    Optional <Venta> delete(Long id);

}
