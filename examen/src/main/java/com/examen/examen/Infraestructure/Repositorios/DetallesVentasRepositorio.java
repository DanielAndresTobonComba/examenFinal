package com.examen.examen.Infraestructure.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.examen.Domain.Entities.Detalles_ventas;

public interface DetallesVentasRepositorio extends JpaRepository <Detalles_ventas , Long>  {

}
