package com.examen.examen.Infraestructure.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.examen.Domain.Entities.Bicicletas;
import com.examen.examen.Domain.Entities.Venta;

public interface VentasRepositorio extends JpaRepository <Venta , Long> {

}
