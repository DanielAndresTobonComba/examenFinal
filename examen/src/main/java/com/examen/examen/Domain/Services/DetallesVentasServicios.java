package com.examen.examen.Domain.Services;

import java.util.Optional;

import com.examen.examen.Domain.Entities.Detalles_ventas;
import com.examen.examen.Domain.Entities.Venta;

public interface DetallesVentasServicios {


    Optional <Detalles_ventas> findById(Long id); 

    Detalles_ventas createOne (Detalles_ventas detalles_ventas);

    Optional<Detalles_ventas> update(Long id, Detalles_ventas detalles_ventas);

    Optional <Detalles_ventas> delete(Long id);

}
